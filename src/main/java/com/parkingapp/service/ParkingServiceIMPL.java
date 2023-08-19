package com.parkingapp.service;

import java.net.URI;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.parkingapp.exception.ResourceNotFoundException;
import com.parkingapp.model.Parking;
import com.parkingapp.repository.ParkingRepo;

@Service
public class ParkingServiceIMPL implements IParkingService {
	@Autowired
	private ParkingRepo repo;

	@Override
	public Parking getOne(int sNo) {
		return this.repo.findById(sNo)
				.orElseThrow(() -> new ResourceNotFoundException("Challan not found with id :" + sNo));
	}

	@Override
	public List<Parking> getAll() {
		if (this.repo.findAll().isEmpty()) {
			throw new ResourceNotFoundException("No Challans FOund");
		} else {
			return this.repo.findAll();
		}
	}

	@Override
	public ResponseEntity<Parking> create(Parking parking) {
		
			parking.setInDate(LocalDate.now());
			parking.setInTime(LocalDateTime.now());
			 Parking save = repo.save(parking);	
			 	
				URI location = ServletUriComponentsBuilder.fromCurrentRequest()
							.path("/{id}")
							.buildAndExpand(save.getSNo())
							.toUri();
				return ResponseEntity.created(location).body(save);	
	}


	@Override
	public ResponseEntity<Parking> delete(int sNo) {
		this.repo.deleteById(sNo);
		return ResponseEntity.ok().build();
	}

	@Override
	public Parking generate(int sNo, Parking parking) {
		return repo.findById(sNo).map(park -> {
			if (null == parking.getVehicleType()) {

			} else {
				park.setVehicleType(parking.getVehicleType());
			}
			if (null == parking.getVehicleNumber()) {

			} else {
				park.setVehicleNumber(parking.getVehicleNumber());
			}
			if (null == parking.getInDate()) {

			} else {
				park.setInDate(parking.getInDate());
			}
			if (null == parking.getInTime()) {

			} else {
				park.setInTime(parking.getInTime());
			}
			if (null == parking.getOutTime()) {
				park.setOutTime(LocalDateTime.now());
			} else {
//				park.setOutTime(parking.getOutTime());
			}

			if (null == parking.getTimeElapsed()) {
				java.time.Duration between = java.time.Duration.between(park.getInTime(), park.getOutTime());
				long hours = between.toHours() - 1;
				park.setTimeElapsed(hours);
			}

			if (null == parking.getAmount()) {
				String car = "4";
				String bike = "2";
				if (park.getVehicleType().equals(car)) {
					Long timeElapsed = park.getTimeElapsed();
					long amt = (timeElapsed * 50) + 100;
					park.setAmount(amt);
				} else {
				if (park.getVehicleType().equals(bike)) {
					Long timeElapsed = park.getTimeElapsed();
					long amt = (timeElapsed * 25) + 50;
					park.setAmount(amt);
					}
				}
			}
			 return repo.save(park);
		})
//				.orElseGet(() -> {
//			return repo.save(parking);
				.orElseThrow(() -> new ResourceNotFoundException ("Parking ticket not found"));
		}/*)*/;
		
	}
//}
