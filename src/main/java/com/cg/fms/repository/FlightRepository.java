package com.cg.fms.repository;

import org.springframework.data.repository.CrudRepository;

import com.cg.fms.entities.Flight;

/**
 * @author Lavam
 *
 */
public interface FlightRepository extends CrudRepository<Flight, Integer> {

}
