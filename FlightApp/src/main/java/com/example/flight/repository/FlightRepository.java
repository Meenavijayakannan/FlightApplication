package com.example.flight.repository;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.flight.model.FlightApp;

public interface FlightRepository extends JpaRepository<FlightApp,Integer> {
	@Query("FROM FlightApp  f WHERE f.startDate=?1 AND f.sourceCity=?2 AND f.destinationCity=?3")
	List findBysourceCityandDestCityandstartDate(LocalDate startDate, String sourceCity, String destinationCity);

}
