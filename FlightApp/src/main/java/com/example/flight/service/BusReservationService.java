package com.example.flight.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.example.flight.model.BusApp;

public interface BusReservationService {

	BusApp addBusData(BusApp busdata);

	List<BusApp> getBusDetails();

	List<Object[]> searchByDate(LocalDate travelDate, String sourceCity, String destinationCity);

	


}
