package com.cg.fms.service;

import java.util.List;

import com.cg.fms.dto.Flight;
import com.cg.fms.exceptions.FlightNotFoundException;

public interface FlightService {
	
	public List<Flight> getAllflights() throws FlightNotFoundException;
	
	public Flight getFlightsByFlightNumber(int flightNumber) throws FlightNotFoundException;
	
	public void saveOrUpdate(Flight flight) throws FlightNotFoundException;
	
	public void delete(int flightNumber) throws FlightNotFoundException;
	
	public void update(Flight flights, int flightNumber) throws FlightNotFoundException;

}
