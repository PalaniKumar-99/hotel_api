package com.example.Hotel_Demo.mapper;

import org.springframework.beans.BeanUtils;

import com.example.Hotel_Demo.entities.RoomsEntity;
import com.example.Hotel_Demo.model.Rooms;

public class RoomsMapper {

	public static Rooms roomsEntityToRoomsMapper(RoomsEntity roomsEntity)
	{
		Rooms rooms = new Rooms();
		BeanUtils.copyProperties(roomsEntity, rooms);
		return rooms;
	}
	
	public static RoomsEntity roomsToRoomsEntityMapper(Rooms rooms)
	{
		RoomsEntity roomsEntity = new RoomsEntity();
		BeanUtils.copyProperties(rooms, roomsEntity);
		return roomsEntity;
	}
}
