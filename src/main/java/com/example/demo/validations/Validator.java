package com.example.demo.validations;

import org.springframework.stereotype.Component;

import com.example.demo.boundary.AddressBoundary;

@Component
public class Validator {

	public boolean validateAddress(AddressBoundary address) {
		return address.getCityAddress() != null && address.getCityName() != null && address.getLocation() != null
				&& !address.getCityAddress().isEmpty() && !address.getCityName().isEmpty()
				&& address.getLocation().getLat() != 0 && address.getLocation().getLng() != 0;
	}

	public boolean validateCityAddress(AddressBoundary address) {
		return address.getCityAddress() != null && !address.getCityAddress().isEmpty();

	}

	public boolean validateCityName(AddressBoundary address) {
		return address.getCityName() != null && !address.getCityName().isEmpty();
	}

	public boolean validateLocation(AddressBoundary address) {
		return address.getLocation() != null && address.getLocation().getLat() != 0
				&& address.getLocation().getLng() != 0;
	}

	public boolean validatePriority(AddressBoundary address) {
		return address.getPriority() >= 0;
	}

	public boolean validateUser(String user) {
		return user != null && !user.isEmpty();
	}
}