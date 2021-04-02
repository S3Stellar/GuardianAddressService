package com.example.demo.dal;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.data.Address;

public interface AddressDao extends PagingAndSortingRepository<Address, String> {
	
	public List<Address> findAllByUser(
			@Param("user") String user,
			Pageable pageable);

	public List<Address> findAllByUserAndCreatedTimestampGreaterThanEqual(
			@Param("user") String user,
			@Param("date") Date date,
			Pageable pageable);
	
	public List<Address> findAllByUserAndPriorityGreaterThanEqual(
			@Param("user") String user,
			@Param("priority") int priority,
			Pageable pageable);
}
