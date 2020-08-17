package com.example.flight.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.flight.model.BusApp;

public interface BusAppRepo extends JpaRepository<BusApp,Integer> {
	@Query("select busNumber,operatorName,departureTime,arrivalTime,duration,price,totalSeats FROM BusApp  b WHERE b.travelDate=?1 AND b.sourceCity=?2 AND b.destinationCity=?3")
	List<Object[]> findBysourceCityandDestinationCityandtravelDate(LocalDate travelDate, String sourceCity,
			String destinationCity);

}
