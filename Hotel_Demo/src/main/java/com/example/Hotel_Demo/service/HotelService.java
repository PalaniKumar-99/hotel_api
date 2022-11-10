package com.example.Hotel_Demo.service;

import com.example.Hotel_Demo.model.Hotel;
import com.example.Hotel_Demo.model.Rooms;

public interface HotelService {
	
	Hotel fetchHotelById(Integer id);
	
	Rooms fetchRoomByHotelIdAndRoomId(Integer hid, Integer rid);
	
	String addHotel(Hotel hotel);
	
	String updateHotel(Hotel hotel);
	
	void deleteRoomByHotelAndRoomId(Integer hid, Integer rid);
	
	void deleteHotel(Integer id);
}
