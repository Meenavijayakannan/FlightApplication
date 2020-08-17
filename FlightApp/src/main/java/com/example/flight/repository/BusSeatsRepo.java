package com.example.flight.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.flight.model.BusSeats;

public interface BusSeatsRepo extends JpaRepository<BusSeats,Integer> {

}
