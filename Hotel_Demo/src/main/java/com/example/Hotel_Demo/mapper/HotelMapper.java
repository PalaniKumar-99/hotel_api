package com.example.Hotel_Demo.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import com.example.Hotel_Demo.entities.HotelEntity;
import com.example.Hotel_Demo.entities.RoomsEntity;
import com.example.Hotel_Demo.model.Hotel;
import com.example.Hotel_Demo.model.Rooms;

public class HotelMapper {

	public static Hotel hotelEntityToHotelMapper(HotelEntity hotelEntity)
	{
		Hotel hotel = new Hotel();
		BeanUtils.copyProperties(hotelEntity, hotel);
		List<Rooms> lstrooms = hotelEntity
								.getRooms()
								.stream()
								.map(RoomsMapper::roomsEntityToRoomsMapper).collect(Collectors.toList());
		hotel.setRooms(lstrooms);
		return hotel;
	}
	
	public static HotelEntity hotelToHotelEntityMapper(Hotel hotel)
	{
		HotelEntity hotelEntity = new HotelEntity();
		BeanUtils.copyProperties(hotel, hotelEntity);
		List<RoomsEntity> lstRoomsEntities = hotel.getRooms().stream().map(RoomsMapper::roomsToRoomsEntityMapper).collect(Collectors.toList());
		hotelEntity.setRooms(lstRoomsEntities);
		return hotelEntity;
	}
}
