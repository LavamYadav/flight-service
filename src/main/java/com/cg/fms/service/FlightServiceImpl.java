package com.cg.fms.service;

import java.math.BigInteger;
import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fms.entities.Flight;
import com.cg.fms.exceptions.FlightNotFoundException;
import com.cg.fms.repository.FlightRepository;

/**
 * @author Lavam
 *
 */
@Service
public class FlightServiceImpl implements FlightService{
	@Autowired
	FlightRepository flightRepository;
	private static final Logger logger = LoggerFactory.getLogger(FlightService.class);

	//getting all flights record by using the method findaAll() of CrudRepository
	public List<Flight> getAllFlights() throws FlightNotFoundException{
		List<Flight> flights = new ArrayList<>();
		logger.info("viewing flight");
		flightRepository.findAll().forEach(flight1 -> flights.add(flight1));
		
		if(flights.isEmpty())
		{
			logger.error("no flights present");
			throw new FlightNotFoundException("No flight found");
		}
		logger.info("viewing flight");
		return flights;
	}

	//getting a specific flight by using the method findById() of CrudRepository
	public Flight getFlightsByFlightNumber(BigInteger flightNumber) throws FlightNotFoundException{
		logger.info("viewing flight using flight number");
		Optional<Flight> flight = flightRepository.findById(flightNumber);
		if(!flight.isPresent())
		{
			logger.error("flight with number"+flightNumber+"not present");
			throw new FlightNotFoundException("No flight found with id "+ flightNumber);
		}
			logger.info("viewing flight");
			return flight.get();
	}

	//saving a specific flight by using the method save() of CrudRepository  
	public void saveOrUpdate(Flight flight) throws FlightNotFoundException{
		logger.info("adding flight");
		logger.info("flight added");
		flightRepository.save(flight);
	}

	//deleting a specific flight by using the method deleteById() of CrudRepository 
	public void delete(BigInteger flightNumber) throws FlightNotFoundException{
		Optional<Flight> flight = flightRepository.findById(flightNumber);
		logger.info("Deleting flight");
		if(!flight.isPresent())
		{
			logger.error("flight not present");
			throw new FlightNotFoundException("No flight found with id "+flightNumber);
		}
		logger.info("deleting flight");
		flightRepository.deleteById(flightNumber);
	}

	//updating a flight
	public void update(Flight flights, BigInteger flightNumber) throws FlightNotFoundException{
		logger.info("Updating flight");
		Optional<Flight> flightUpdate = flightRepository.findById(flightNumber);
		if(!flightUpdate.isPresent())
		{
			logger.error("flight with number"+flightNumber+"not present");
			throw new FlightNotFoundException("No flight found with id "+flightNumber);
		}
		logger.info("Updating Flight");
		flightUpdate.get().setCarrierName(flights.getCarrierName());
		flightUpdate.get().setSeatCapacity(flights.getSeatCapacity());
		flightRepository.save(flightUpdate.get());
	}
}