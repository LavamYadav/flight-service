package com.cg.fms.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table
public class Schedule {
	@Id
	@Column(name = "schedule_Id")
	private int scheduleId;

	@OneToOne(fetch = FetchType.EAGER)
	private Airport sourceAirport;

	@OneToOne(fetch = FetchType.EAGER)
	private Airport destinationAirport;

	@Column(name = "departure_date_time")
	@DateTimeFormat(pattern = "mm-dd-yyyy HH:mm:ss")
	private LocalDateTime departureDateTime;

	@Column(name = "arrival_date_time")
	@DateTimeFormat(pattern = "mm-dd-yyyy HH:mm:ss")
	private LocalDateTime arrivalDateTime;

	public Schedule() {
		super();

	}

	public int getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	public Airport getSourceAirport() {
		return sourceAirport;
	}

	public void setSourceAirport(Airport sourceAirport) {
		this.sourceAirport = sourceAirport;
	}

	public Airport getDestinationAirport() {
		return destinationAirport;
	}

	public void setDestinationAirport(Airport destinationAirport) {
		this.destinationAirport = destinationAirport;
	}

	public LocalDateTime getDepartureDateTime() {
		return departureDateTime;
	}

	public void setDepartureDateTime(LocalDateTime departureDateTime) {
		this.departureDateTime = departureDateTime;
	}

	public LocalDateTime getArrivalDateTime() {
		return arrivalDateTime;
	}

	public void setArrivalDateTime(LocalDateTime arrivalDateTime) {
		this.arrivalDateTime = arrivalDateTime;
	}

}
