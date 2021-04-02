package com.example.demo.service;

import java.util.List;

import com.example.demo.boundary.AddressBoundary;

public interface AddressService {
	public AddressBoundary createAddress(AddressBoundary address);

	public AddressBoundary getSpecificAddress(String addressId);

	public void updateAddress(AddressBoundary address, String addressId);

	public void deleteAll();
	
	public void deleteAddressById(String addressId);
	
	public List<AddressBoundary> getAddressesByUser(String user, String sortBy,
			String sortOrder, int page, int size);
	
	public List<AddressBoundary> getAddressByCreatedTimestamp(String email, String value, String sortBy,
			String sortOrder, int page, int size);
	
	public List<AddressBoundary> getAddressesByPriority(String user, String value, String sortBy, String 
			sortOrder, int page, int size);

	public void delete(String addressId);
}
