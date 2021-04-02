package com.example.demo.boundary;

import java.util.Date;

public class AddressBoundary {

	private String id;
	private String user;
	private String cityAddress;
	private String cityName;
	private Date createdTimestamp;
	private LocationBoundary location;
	private int priority;
	
	public AddressBoundary() {
		super();
	}

	public AddressBoundary(String user, String cityAddress, String cityName, LocationBoundary location, int priority) {
		super();
		this.user = user;
		this.cityAddress = cityAddress;
		this.cityName = cityName;
		this.location = location;
		this.priority = priority;
	}

	public AddressBoundary(String id, String user, String cityAddress, String cityName, Date createdTimestamp,
			LocationBoundary location, int priority) {
		super();
		this.id = id;
		this.user = user;
		this.cityAddress = cityAddress;
		this.cityName = cityName;
		this.createdTimestamp = createdTimestamp;
		this.location = location;
		this.priority = priority;
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
	
	

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	@Override
	public String toString() {
		return "AddressBoundary [id=" + id + ", user=" + user + ", cityAddress=" + cityAddress + ", cityName="
				+ cityName + ", createdTimestamp=" + createdTimestamp + ", location=" + location + ", priority="
				+ priority + "]";
	}
	
	

	
	
}
