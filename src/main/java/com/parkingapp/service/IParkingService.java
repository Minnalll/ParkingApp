package com.parkingapp.service;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;

import com.parkingapp.model.Parking;

public interface IParkingService {
	
	public Parking getOne(int sNo);
	
	List<Parking> getAll();
	
	ResponseEntity<Parking> create (Parking parking);
	
	ResponseEntity<Parking> delete (int sNo);
	
	public Parking generate(int sNo, Parking parking);
	
}
