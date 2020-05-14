package com.cg.fms.service;

import java.math.BigInteger;
import java.util.List;

import com.cg.fms.entities.Flight;
import com.cg.fms.exceptions.FlightNotFoundException;

/**
 * @author Lavam
 *
 */
public interface FlightService {
	
	public List<Flight> getAllFlights() throws FlightNotFoundException;
	
	public Flight getFlightsByFlightNumber(BigInteger flightNumber) throws FlightNotFoundException;
	
	public void saveOrUpdate(Flight flight) throws FlightNotFoundException;
	
	public void delete(BigInteger flightNumber) throws FlightNotFoundException;
	
	public void update(Flight flights, BigInteger flightNumber) throws FlightNotFoundException;

}
