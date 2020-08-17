package com.example.flight.controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.flight.model.FlightApp;
import com.example.flight.repository.FlightRepository;
@RestController
public class FlightController {
	@Autowired
	FlightRepository flightrepo;
@RequestMapping("/")
public String home() {
	return "Welcome home page";
}
@PostMapping("/addFlights")
public String addFlights(FlightApp flightDto) {
	flightrepo.save(flightDto);
	return "added";
}
@GetMapping("/getFlights")
public List<FlightApp> getFlights() {
	List<FlightApp> flightList = flightrepo.findAll();
	flightList.stream().forEach(x -> System.out.println(x));
	return flightList;
}
@GetMapping("/getbydate")
public List<FlightApp> getByDate(@RequestParam(value="startDate")@DateTimeFormat(iso=DateTimeFormat.ISO.DATE)LocalDate startDate,@RequestParam(value="sourceCity")String sourceCity,@RequestParam(value="destinationCity") String destinationCity) {
	@SuppressWarnings("unchecked")
	List<FlightApp> flightList=flightrepo.findBysourceCityandDestCityandstartDate(startDate,sourceCity,destinationCity);
return flightList;
}
@DeleteMapping("/delete/{id}")
public Map<String, Boolean> deleteEmployee(@PathVariable(value = "flightNumber") int flightNumber)
     throws Exception {
    Object flightInfo = flightrepo.findById(flightNumber).orElseThrow(() -> new Exception("Flight not found for this id :: " + flightNumber));
    flightrepo.deleteById(flightNumber);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return response;
}
@PutMapping("/update")
public Map<String, Boolean> updateEmployee(FlightApp flightDto)
	     throws Exception {
	 Map<String, Boolean> response = new HashMap<>();
	int flightNumber=flightDto.getFlightNumber();
	    Optional<FlightApp> flightInfo = flightrepo.findById(flightNumber);
	    if(flightInfo.isPresent()) {
	    	flightrepo.save(flightDto);
	    response.put("updated", Boolean.TRUE);
	    }else {
	    	 response.put("not-updated", Boolean.FALSE);
	    }
	    return response;
	   
	}
}
