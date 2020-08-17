package com.example.flight.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.flight.model.User;

public interface UserRepo extends JpaRepository<User,Integer> {

}
