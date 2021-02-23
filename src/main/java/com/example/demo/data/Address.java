package com.example.demo.data;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Addresses")
public class Address {
	@Id
	private String id;
	private String user;
	private String cityAddress;
	private String cityName;
	private Date createdTimestamp;
	private Location location;

	public Address() {
		super();
	}

	public Address(String user, String cityAddress, String cityName, Location location) {
		super();
		this.user = user;
		this.cityAddress = cityAddress;
		this.cityName = cityName;
		this.location = location;
	}

	public Address(String user, String cityAddress, String cityName, Date createdTimestamp,
			Location location) {
		super();
		this.user = user;
		this.cityAddress = cityAddress;
		this.cityName = cityName;
		this.createdTimestamp = createdTimestamp;
		this.location = location;
	}
	
	public Address(String id, String user, String cityAddress, String cityName, Date createdTimestamp,
			Location location) {
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

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", user=" + user + ", cityAddress=" + cityAddress + ", cityName=" + cityName
				+ ", createdTimestamp=" + createdTimestamp + ", location=" + location + "]";
	}

}