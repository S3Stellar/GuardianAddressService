package com.example.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.boundary.AddressBoundary;
import com.example.demo.service.AddressService;
import com.example.demo.utility.RouteFilterType;

@RestController
public class AddressController {
	private AddressService addressService;

	@Autowired
	public void setAddressService(AddressService addressService) {
		this.addressService = addressService;
	}

	@RequestMapping(path = "/addresses", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public AddressBoundary create(@RequestBody AddressBoundary address) {
		return this.addressService.createAddress(address);
	}

	@RequestMapping(path = "/addresses/{addressId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public AddressBoundary getSpecificAddress(@PathVariable("addressId") String addressId) {
		return this.getSpecificAddress(addressId);
	}

	@RequestMapping(path = "/addresses/{addressId}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateAddress(@RequestBody AddressBoundary address, @PathVariable("addressId") String addressId) {
		this.addressService.updateAddress(address, addressId);
	}

	@RequestMapping(path = "/addresses", method = RequestMethod.DELETE)
	public void deleteAll() {
		this.addressService.deleteAll();
	}

	@RequestMapping(path = "/addresses/byEmail/{user}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public AddressBoundary[] getAddressesByEmail(@PathVariable("user") String user,
			@RequestParam(name = "filterType", required = false, defaultValue = "") String type,
			@RequestParam(name = "filterValue", required = false) String value,
			@RequestParam(name = "sortBy", required = false, defaultValue = "createdTimestamp") String sortBy,
			@RequestParam(name = "sortOrder", required = false, defaultValue = "DESC") String sortOrder,
			@RequestParam(name = "page", required = false, defaultValue = "0") int page,
			@RequestParam(name = "size", required = false, defaultValue = "10") int size) {

		switch (type) {
		case RouteFilterType.BY_CREATED_TIMESTAMP:
			return this.addressService.getAddressByCreatedTimestamp(user, value, sortBy, sortOrder, page, size)
					.toArray(new AddressBoundary[0]);
		default:
			return this.addressService.getAddressesByUser(user, sortBy, sortOrder, page, size)
					.toArray(new AddressBoundary[0]);
		}

	}

}