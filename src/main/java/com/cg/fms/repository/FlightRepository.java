package com.cg.fms.repository;

import org.springframework.data.repository.CrudRepository;

import com.cg.fms.dto.Flight;

public interface FlightRepository extends CrudRepository<Flight, Integer> {

}
