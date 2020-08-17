package com.example.flight.serviceImpl;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.flight.model.BusApp;
import com.example.flight.model.FlightApp;
import com.example.flight.repository.BusAppRepo;
import com.example.flight.service.BusReservationService;
@Service
public class BusReservationServiceImpl implements BusReservationService{
    @Autowired
    BusAppRepo busAppRepo;
	@Override
	public BusApp addBusData(BusApp busData) {
		Duration dur=Duration.between(busData.getArrivalTime(), busData.getDepartureTime());
		busData.setDuration( Math.abs(dur.toHours()));
		return busAppRepo.save(busData);
	}
	@Override
	public List<BusApp> getBusDetails() {
			List<BusApp> busDetailsList = busAppRepo.findAll(sortByPrice());
			busDetailsList.stream().forEach(x -> System.out.println(x));
			return busDetailsList;
	}
	private Sort sortByPrice() {
		return new Sort(Sort.Direction.ASC,"price");
	}
	@Override
	public List<Object[]> searchByDate(LocalDate travelDate, String sourceCity, String destinationCity) {
		return busAppRepo.findBysourceCityandDestinationCityandtravelDate(travelDate,sourceCity,destinationCity);
	}
	

}
