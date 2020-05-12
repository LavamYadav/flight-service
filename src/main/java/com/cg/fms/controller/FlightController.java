package com.cg.fms.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.cg.fms.entities.Flight;
import com.cg.fms.exceptions.FlightNotFoundException;
import com.cg.fms.payload.RestResponse;
import com.cg.fms.service.FlightServiceImpl;


/**
 * @author Lavam
 *
 */
@RestController
@RequestMapping("/flight")
public class FlightController {

	@Autowired
	FlightServiceImpl flightService;
	private static final Logger logger = LoggerFactory.getLogger(FlightController.class);

    //creating a get mapping that retrieves all the flights detail from the database
	@GetMapping("/showAllFlights")
	public ResponseEntity<?> getAllFlights() {
		logger.info("viewing flight");
		try {
			logger.info("display flight");
			return ResponseEntity.ok(new RestResponse<>(true, "Flights Found",flightService.getAllflights()));
		} catch (FlightNotFoundException e) {
			logger.error("no flight present");
			return ResponseEntity.ok(new RestResponse<>(false,e.getMessage()));
		}
	
	}

    //creating a get mapping that retrieves the detail of a specific flight  
	@GetMapping("/showFlightByFlightNumber/{flightNumber}")
	private ResponseEntity<?> getFlights(@PathVariable("flightNumber") int flightNumber) {
		logger.info("search flight");
		try {
			
			return ResponseEntity.ok(new RestResponse<>(true, "Flights Found",flightService.getFlightsByFlightNumber(flightNumber)));
			
		} catch (FlightNotFoundException e) {
			logger.error("no flight present");
			return ResponseEntity.ok(new RestResponse<>(false,e.getMessage()));
		}
	}

    //creating a delete mapping that deletes a specified flight 
	@DeleteMapping("/deleteFlight/{flightNumber}")
	public ResponseEntity<?> deleteFlight(@PathVariable("flightNumber") int flightNumber) {
		logger.info("removing flight");
		
		try {
			flightService.delete(flightNumber);
			logger.info("flight removed");
			return ResponseEntity.ok(new RestResponse<>(false,"Flight deleted"));
		} catch (FlightNotFoundException e) {
			logger.info("flight not removed");
			return ResponseEntity.ok(new RestResponse<>(false,e.getMessage()));
		}
	}

    //creating post mapping that post the flight detail in the database 
	@PostMapping("/addFlight")
	public ResponseEntity<?> saveFlight(@Valid @RequestBody Flight flights) {
		logger.info("adding flight");
		try {
			flightService.saveOrUpdate(flights);
			logger.info("added flight");
			return ResponseEntity.ok(new RestResponse<>(true, "Flights Found",flights.getFlightNumber()));
			
		} catch (FlightNotFoundException e) {
			logger.error("flight not added");
			return ResponseEntity.ok(new RestResponse<>(false,e.getMessage()));
		}
		
	}

    //creating put mapping that updates the flight detail 
	@PutMapping("/modifyFlight")
	public ResponseEntity<?> update(@Valid @RequestBody Flight flights) {
		logger.info("modifying flight");
		try {
			flightService.saveOrUpdate(flights);
			logger.info("modified flight");
			return ResponseEntity.ok(new RestResponse<>(true, "Flights Found",flights));
		} catch (FlightNotFoundException e) {
			logger.error("flight not modified");
			return ResponseEntity.ok(new RestResponse<>(false,e.getMessage()));
		}
		
	}
}
