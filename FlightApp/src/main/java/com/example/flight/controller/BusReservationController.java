package com.example.flight.controller;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.flight.model.BusApp;
import com.example.flight.model.FlightApp;
import com.example.flight.service.BusReservationService;
@RestController
public class BusReservationController {
	
	@Autowired
	BusReservationService busService;

	@RequestMapping("/getPage")
	public String home() {
		return "Welcome home page";
	}
	@PostMapping("/addBus")
	public BusApp addBus(BusApp busdata) {
		return busService.addBusData(busdata);
	}
	@GetMapping("/getBusDetails")
	public List<BusApp> getFlights() {
		List<BusApp> list= busService.getBusDetails();
		list.stream().forEach(action->System.out.println(action));
		 Collections.sort(list, new Comparator<BusApp>() {
	           public int compare(BusApp p1, BusApp p2) {
//	        	   int arrivalTime= p1.getArrivalTime().compareTo(p2.getArrivalTime());
	        	   int operatorName=p1.getOperatorName().compareTo(p2.getOperatorName());
//	        	   In departureTime=p1.getDepartureTime().compareTo(p2.getDepartureTime());
//	        	   int durOne=Duration.between(p1.getArrivalTime(),p1.getDepartureTime()).compareTo(Duration.between(p2.getArrivalTime(),p2.getDepartureTime()));
//	        	  if(arrivalTime==0) {
//	        		  return (departureTime==0)?(operatorName==0)?durOne:operatorName:departureTime;
//	        	  }else {
//	        		  return arrivalTime;
//	        	  }
	        	   return operatorName;
//	               return Long.valueOf(p1.getArrivalTime().getHour()).compareTo((long) p2.getArrivalTime().getHour());
	           }
	    
		});
		 list.stream().forEach(action->System.out.println(action));
		 return list;
	}
	@GetMapping("/searchbydate")
	public List<Object[]> searchByDate(@RequestParam(value="travelDate")@DateTimeFormat(iso=DateTimeFormat.ISO.DATE)LocalDate travelDate,@RequestParam(value="sourceCity")String sourceCity,@RequestParam(value="destinationCity") String destinationCity) {
		List<Object[]> searchList=  busService.searchByDate(travelDate,sourceCity,destinationCity);
		if(Objects.nonNull(searchList)) {
			
			  int it = searchList.stream().toArray().length;
			 
				System.out.println(it);
			 
//			 Arrays.stream(it).iterator()
			
			
//			Stream list = searchList.stream().sorted(new Comparator() {
//				@Override
//				public int compare(Object o1, Object o2) {
//					// TODO Auto-generated method stub
//					Object[] arr = (Object[])o1;
//					Object[] arr1 = (Object[])o2;
//					return Integer.valueOf((String)arr[1]).compareTo(Integer.valueOf((String)arr1[1]));
//				
//				}
//			});
			
		
		}
		return searchList;
	}
	
}
