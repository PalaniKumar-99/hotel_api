package com.example.Hotel_Demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Hotel_Demo.entities.HotelEntity;

public interface HotelRepository extends JpaRepository<HotelEntity, Integer> {

}
