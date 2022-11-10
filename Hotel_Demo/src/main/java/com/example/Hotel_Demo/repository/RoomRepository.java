package com.example.Hotel_Demo.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.Hotel_Demo.entities.RoomsEntity;

public interface RoomRepository extends JpaRepository<RoomsEntity, Integer> 
{
	@Query(value = "select * from rooms where hotel_id = ? and id = ?",nativeQuery = true)
	Optional<RoomsEntity> queryByHotelIdAndRoomId(Integer hid, Integer rid);
	
	@Query(value = "delete from rooms where hotel_id = ? and id = ?",nativeQuery = true)
	@Modifying
	@Transactional
	int deleteRoom(Integer hid, Integer rid);
}
