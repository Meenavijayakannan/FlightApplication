package com.example.flight.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
@Entity
public class FlightDto {
	@Id
	private int flightNumber;
	@Column(nullable=false,unique=true)
	private String sourceCity;
	@Column(nullable=false,unique=true)
	private String destinationCity;
	private int stops;
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss a")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss a")
	@JsonDeserialize(using=LocalDateTimeDeserializer.class)
	@JsonSerialize(using=LocalDateTimeSerializer.class)
	private LocalDateTime reachedtime;
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss a")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss a")
	@JsonDeserialize(using=LocalDateTimeDeserializer.class)
	@JsonSerialize(using=LocalDateTimeSerializer.class)
	private LocalDateTime arrivaltime;
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonDeserialize(using=LocalDateDeserializer.class)
	@JsonSerialize(using=LocalDateSerializer.class)
	private LocalDate startDate;
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date reachedDate;
	public int getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getSourceCity() {
		return sourceCity;
	}
	public void setSourceCity(String sourceCity) {
		this.sourceCity = sourceCity;
	}
	public String getDestinationCity() {
		return destinationCity;
	}
	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}
	public int getStops() {
		return stops;
	}
	public void setStops(int stops) {
		this.stops = stops;
	}
	
	public LocalDateTime getReachedtime() {
		return reachedtime;
	}
	public void setReachedtime(LocalDateTime reachedtime) {
		this.reachedtime = reachedtime;
	}
	
	@Override
	public String toString() {
		return "FlightDto [flightNumber=" + flightNumber + ", sourceCity=" + sourceCity + ", destinationCity="
				+ destinationCity + ", stops=" + stops + ", arrivalTime=" + arrivaltime + ", reachedtime=" + reachedtime
				+ ", startDate=" + startDate + ", reachedDate=" + reachedDate + "]";
	}
	public LocalDateTime getArrivaltime() {
		return arrivaltime;
	}
	public void setArrivaltime(LocalDateTime arrivaltime) {
		this.arrivaltime = arrivaltime;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public Date getReachedDate() {
		return reachedDate;
	}
	public void setReachedDate(Date reachedDate) {
		this.reachedDate = reachedDate;
	}
}
