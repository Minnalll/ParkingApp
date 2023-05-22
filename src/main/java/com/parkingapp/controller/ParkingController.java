package com.parkingapp.controller;

import java.net.URI;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.parkingapp.model.Parking;
import com.parkingapp.service.ParkingServiceIMPL;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/parking")
public class ParkingController {
	@Autowired
	private ParkingServiceIMPL service;
	
	@GetMapping("/findone/{sNo}")
	public Parking findOne(@PathVariable int sNo) {
		return service.getOne(sNo);		
	}
	
	@GetMapping("/findall")
	public List<Parking> findAll() {
		return service.getAll();		
	}
	
	@PostMapping("/create")
	public ResponseEntity<Parking> create( @Valid @RequestBody  Parking parking){	
		ResponseEntity<Parking> create = service.create(parking);
		return create;	
	}
	
//	@PostMapping("/create")
//	public Response create( @Valid @RequestBody  Parking parking){	
//		Response create = service.create(parking);
//		return create;	
//	}
	
	@DeleteMapping("/delete/{sNo}")
	public ResponseEntity<Parking> delete(@PathVariable int sNo) {
		return service.delete(sNo);		
	}
	@PutMapping("/generate/{sNo}")
	public Parking generate(@PathVariable int sNo, @RequestBody Parking parking) {
		return service.generate(sNo, parking);		
	}
}
