package com.example.demo.converter;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.example.demo.boundary.AddressBoundary;
import com.example.demo.boundary.LocationBoundary;
import com.example.demo.data.Address;
import com.example.demo.data.Location;

@Component
public class AddressConverter {
	
	public Address toEntity(AddressBoundary addressBoundary) {
		
		return new Address(
				addressBoundary.getUser(),
				addressBoundary.getCityAddress(),
				addressBoundary.getCityName(),
				new Date(),
				new Location(addressBoundary.getLocation().getLat(),
						addressBoundary.getLocation().getLng()),addressBoundary.getPriority());
	}

	public AddressBoundary toBoundary(Address address) {
		
		return new AddressBoundary(
				address.getId(),
				address.getUser(),
				address.getCityAddress(),
				address.getCityName(),
				address.getCreatedTimestamp(),
				new LocationBoundary(address.getLocation().getLat(),
						address.getLocation().getLng()), address.getPriority());
	}
}