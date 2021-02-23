package com.example.demo.boundary;

import java.util.Date;

public class AddressBoundary {

	private String id;
	private String user;
	private String cityAddress;
	private String cityName;
	private Date createdTimestamp;
	private LocationBoundary location;

	public AddressBoundary() {
		super();
	}

	public AddressBoundary(String user, String cityAddress, String cityName, LocationBoundary location) {
		super();
		this.user = user;
		this.cityAddress = cityAddress;
		this.cityName = cityName;
		this.location = location;
	}

	public AddressBoundary(String id, String user, String cityAddress, String cityName, Date createdTimestamp,
			LocationBoundary location) {
		super();
		this.id = id;
		this.user = user;
		this.cityAddress = cityAddress;
		this.cityName = cityName;
		this.createdTimestamp = createdTimestamp;
		this.location = location;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getCityAddress() {
		return cityAddress;
	}

	public void setCityAddress(String cityAddress) {
		this.cityAddress = cityAddress;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Date getCreatedTimestamp() {
		return createdTimestamp;
	}

	public void setCreatedTimestamp(Date createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}

	public LocationBoundary getLocation() {
		return location;
	}

	public void setLocation(LocationBoundary location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "AddressBoundary [id=" + id + ", cityAddress=" + cityAddress + ", cityName=" + cityName
				+ ", createdTimestamp=" + createdTimestamp + ", location=" + location + "]";
	}
}
