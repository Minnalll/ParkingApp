package com.parkingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.stereotype.Repository;

import com.parkingapp.model.Parking;

@Repository
public interface ParkingRepo extends JpaRepository<Parking, Integer> {
	
}
