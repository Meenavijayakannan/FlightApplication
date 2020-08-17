package com.example.flight.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.flight.model.BookingSeats;

public interface BookingSeatsRepo extends JpaRepository<BookingSeats,Integer> {

}
