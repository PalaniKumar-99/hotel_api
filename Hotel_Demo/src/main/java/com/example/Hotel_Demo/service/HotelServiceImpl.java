package com.example.Hotel_Demo.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.Hotel_Demo.entities.HotelEntity;
import com.example.Hotel_Demo.entities.RoomsEntity;
import com.example.Hotel_Demo.exception.HotelNotFoundException;
import com.example.Hotel_Demo.exception.RoomNotFoundException;
import com.example.Hotel_Demo.mapper.HotelMapper;
import com.example.Hotel_Demo.mapper.RoomsMapper;
import com.example.Hotel_Demo.model.Hotel;
import com.example.Hotel_Demo.model.Rooms;
import com.example.Hotel_Demo.repository.HotelRepository;
import com.example.Hotel_Demo.repository.RoomRepository;

@Service
public class HotelServiceImpl implements HotelService
{
	@Autowired
	private HotelRepository hotelRepository;
	
	@Autowired
	private RoomRepository roomsRepository;

	@Cacheable(value = "hotelDetails", key = "#id", unless = "#result == null")
	@Override
	public Hotel fetchHotelById(Integer id) {
		Optional<HotelEntity> opt = hotelRepository.findById(id);
		if(opt.isPresent())
		{
			Hotel hotel = HotelMapper.hotelEntityToHotelMapper(opt.get());
			return hotel;
		}
		else
		{
			throw new HotelNotFoundException(String.format("Hotel with id : %id doesn't exit", id));
		}
		
	}

	@Override
	public Rooms fetchRoomByHotelIdAndRoomId(Integer hid, Integer rid) {
		Optional<RoomsEntity> opt = roomsRepository.queryByHotelIdAndRoomId(hid, rid);
		if(opt.isPresent())
		{
			RoomsEntity roomsEntity = opt.get();
			Rooms room = RoomsMapper.roomsEntityToRoomsMapper(roomsEntity);
			return room;
		}
		else
		{
			throw new RoomNotFoundException(String.format("Room with hotel id : %d, and room id : %d doesn't exit",hid,rid));
		}
	}

	@Override
	public String addHotel(Hotel hotel) {
		HotelEntity hotelEntity = HotelMapper.hotelToHotelEntityMapper(hotel);
		if(hotelRepository.existsById(hotelEntity.getId()))
		{
			return "Hotel details with id "+hotel.getId()+"already exist";
		}
		else
		{
			hotelRepository.save(hotelEntity);
			return "Hotel details added to the database";
		}
		
	}

	@Override
	public String updateHotel(Hotel hotel) {
		HotelEntity hotelEntity = new HotelEntity();
		BeanUtils.copyProperties(hotel, hotelEntity);
		if(hotelRepository.existsById(hotelEntity.getId()))
		{
			hotelRepository.save(hotelEntity);
			return "Hotel with id "+hotel.getId()+" was updated";
		}
		else
		{
			throw new HotelNotFoundException(String.format("Hotel with id : %id doesn't exit", hotel.getId()));
		}
		
		
	}

	@Override
	public void deleteRoomByHotelAndRoomId(Integer hid, Integer rid) {
		int dele =roomsRepository.deleteRoom(hid, rid);
		if(dele != 1)
		{
			throw new RoomNotFoundException(String.format("Hotel with id : %d and Room with id : %d doesn't exist", hid,rid));
		}
		
	}

	@CacheEvict(value = "hotelDetails", key = "#id")
	@Override
	public void deleteHotel(Integer id) {
		if(hotelRepository.existsById(id))
		{
			hotelRepository.deleteById(id);
		}
		else
		{
			throw new HotelNotFoundException(String.format("Hotel with id : %id doesn't exit", id));
		}
		
	}

}
