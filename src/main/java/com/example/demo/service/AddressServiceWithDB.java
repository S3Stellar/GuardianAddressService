package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.demo.boundary.AddressBoundary;
import com.example.demo.converter.AddressConverter;
import com.example.demo.dal.AddressDao;
import com.example.demo.data.Address;
import com.example.demo.data.Location;
import com.example.demo.exceptions.AddressNotFoundException;
import com.example.demo.exceptions.InvalidAddressException;
import com.example.demo.exceptions.InvalidUserException;
import com.example.demo.utility.DateUtils;
import com.example.demo.validations.Validator;

@Service
public class AddressServiceWithDB implements AddressService {

	private AddressDao addressDao;
	private AddressConverter addressConverter;
	private Validator validator;
	private DateUtils dateUtils;

	@Autowired
	public void setAddressConverter(AddressConverter addressConverter) {
		this.addressConverter = addressConverter;
	}

	@Autowired
	public void setAddressDao(AddressDao addressDao) {
		this.addressDao = addressDao;
	}

	@Autowired
	public void setValidator(Validator validator) {
		this.validator = validator;
	}

	@Autowired
	public void setDateUtils(DateUtils dateUtils) {
		this.dateUtils = dateUtils;
	}

	@Override
	public AddressBoundary createAddress(AddressBoundary addressBoundary) {

		if (!validator.validateAddress(addressBoundary)) {
			throw new InvalidAddressException("Address is invalid.");
		}
		return this.addressConverter.toBoundary(this.addressDao.save(this.addressConverter.toEntity(addressBoundary)));
	}

	@Override
	public AddressBoundary getSpecificAddress(String addressId) {
		System.err.println(addressId);
		return this.addressConverter.toBoundary(this.addressDao.findById(addressId)
				.orElseThrow(() -> new AddressNotFoundException("Address with id" + addressId + " was not found")));
	}

	@Override
	public void updateAddress(AddressBoundary address, String addressId) {
		Address oldAddress = this.addressDao.findById(addressId)
				.orElseThrow(() -> new AddressNotFoundException("Address with id" + addressId + " was not found"));

		if (validator.validateCityAddress(address)) {
			oldAddress.setCityAddress(address.getCityAddress());
		}

		if (validator.validateCityName(address)) {
			oldAddress.setCityName(address.getCityName());
		}

		if (validator.validateLocation(address)) {
			oldAddress.setLocation(new Location(address.getLocation().getLat(), address.getLocation().getLng()));
		}

		if (validator.validatePriority(address)) {
			oldAddress.setPriority(address.getPriority());
		}

		this.addressDao.save(oldAddress);
	}

	@Override
	public void deleteAll() {
		this.addressDao.deleteAll();
	}

	@Override
	public void deleteAddressById(String addressId) {
		this.addressDao.deleteById(addressId);
	}

	@Override
	public List<AddressBoundary> getAddressesByUser(String user, String sortBy, String sortOrder, int page, int size) {

		if (!validator.validateUser(user)) {
			throw new InvalidUserException("Invalid user");
		}

		Direction direction = sortOrder.equals(Direction.ASC.toString()) ? Direction.ASC : Direction.DESC;

		return this.addressDao.findAllByUser(user, PageRequest.of(page, size, direction, sortBy)).stream()
				.map(this.addressConverter::toBoundary).collect(Collectors.toList());

	}

	@Override
	public List<AddressBoundary> getAddressByCreatedTimestamp(String user, String value, String sortBy,
			String sortOrder, int page, int size) {

		if (!validator.validateUser(user)) {
			throw new InvalidUserException("Invalid user");
		}

		Direction direction = sortOrder.equals(Direction.ASC.toString()) ? Direction.ASC : Direction.DESC;
		return this.addressDao
				.findAllByUserAndCreatedTimestampGreaterThanEqual(user, dateUtils.parseDate(value),
						PageRequest.of(page, size, direction, sortBy))
				.stream().map(this.addressConverter::toBoundary).collect(Collectors.toList());

	}

	@Override
	public List<AddressBoundary> getAddressesByPriority(String user, String value, String sortBy, String sortOrder,
			int page, int size) {
		if (!validator.validateUser(user)) {
			throw new InvalidUserException("Invalid user");
		}
		Sort sort = Sort.by(Sort.Order.asc("priority"), Sort.Order.desc("createdTimestamp"));
		PageRequest pageRequest = PageRequest.of(page, size, sort);
		return this.addressDao.findAllByUserAndPriorityGreaterThanEqual(user, Integer.valueOf(value), pageRequest)
				.stream().map(this.addressConverter::toBoundary).collect(Collectors.toList());
	}

	@Override
	public void delete(String addressId) {
		this.addressDao.deleteById(addressId);

	}
}
