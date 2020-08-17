package com.example.flight.commandLineRunner;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.flight.model.BookingSeats;
import com.example.flight.model.BusApp;
import com.example.flight.model.BusSeats;
import com.example.flight.model.User;
import com.example.flight.repository.BookingSeatsRepo;
import com.example.flight.repository.BusAppRepo;
import com.example.flight.repository.BusSeatsRepo;
import com.example.flight.repository.UserRepo;
@Component
public class TicketBookingCommandLineRunner implements CommandLineRunner {

	@Autowired
	private UserRepo userrepo;
	@Autowired
	private BusSeatsRepo seatrepo;
	@Autowired
	private BusAppRepo busRepo;
	@Autowired
	private BookingSeatsRepo bookSeatsRepo;
	
	@Override
	public void run(String... args) throws Exception {
		insertBusData();
		insertUserData();
//		bookSeats();
		
	}

  private LocalDateTime dateFormatter(String string) {
	LocalDateTime d=LocalDateTime.parse(string,DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss a",Locale.US));
		return d;
	}


  private void insertBusData() throws ParseException {
		BusApp busData=new BusApp(101,"chennai","trichy",localdate("2009-08-06"),date("2009-08-06"),
				dateFormatter("2009-08-06 09:08:06 AM"),dateFormatter("2009-08-07 10:08:06 PM"),"srm",1400,12);
	    BusApp busData1=new BusApp(102,"chennai","madurai",localdate("2010-11-04"),date("2010-11-08"),
				dateFormatter("2010-11-04 08:08:06 AM"),dateFormatter("2010-11-05 10:08:06 PM"),"parveen",200,30);
	    BusApp busData2=new BusApp(103,"madurai","chennai",localdate("2020-11-04"),date("2020-11-08"),
				dateFormatter("2020-11-04 07:08:06 AM"),dateFormatter("2020-11-05 10:08:06 PM"),"parveen",2000,30);
	    BusApp busData3=new BusApp(104,"madurai","chennai",localdate("2020-11-04"),date("2020-11-08"),
				dateFormatter("2020-11-04 10:08:06 AM"),dateFormatter("2020-11-05 11:08:06 PM"),"sns",1600,30);
	    BusApp busData4=new BusApp(105,"madurai","chennai",localdate("2020-11-04"),date("2020-11-08"),
				dateFormatter("2020-11-04 07:08:06 AM"),dateFormatter("2020-11-05 08:08:06 PM"),"tat",700,30);
	    BusApp busData5=new BusApp(106,"madurai","chennai",localdate("2020-11-04"),date("2020-11-08"),
				dateFormatter("2020-11-04 06:08:06 AM"),dateFormatter("2020-11-05 05:08:06 PM"),"apple",2000,30);
		busRepo.save(busData);
		busRepo.save(busData1);
		busRepo.save(busData2);
		busRepo.save(busData3);
		busRepo.save(busData4);
		busRepo.save(busData5);
	}


  private Date date(String string) throws ParseException {
	SimpleDateFormat d=new SimpleDateFormat("yyyy-MM-dd");
	return d.parse(string);
	
   }
  private LocalDate localdate(String string) throws ParseException {
	  LocalDate d=LocalDate.parse(string,DateTimeFormatter.ofPattern("yyyy-MM-dd",Locale.US));
	return d;
	
   }


	private void insertUserData() {
		User user1 = new User("user1");
		User user2 = new User("user2");
		User user3 = new User("user3");
		userrepo.save(user1);
		userrepo.save(user2);
		userrepo.save(user3);
		BookingSeats booking1=new BookingSeats(1,101,user1);
		BookingSeats booking2=new BookingSeats(1,102,user2);
		bookSeatsRepo.save(booking1);
		bookSeatsRepo.save(booking2);
	}

}
