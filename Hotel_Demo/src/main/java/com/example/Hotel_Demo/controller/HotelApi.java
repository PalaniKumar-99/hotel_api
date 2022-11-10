package com.example.Hotel_Demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Hotel_Demo.model.Hotel;
import com.example.Hotel_Demo.model.Rooms;
import com.example.Hotel_Demo.service.HotelService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import lombok.val;

@RestController
@RequestMapping(value = "/api")
public class HotelApi {
	
	@Autowired
	private HotelService service;
	
	@GetMapping(value = "/hotel/{id}")
	@ApiOperation(value = "It will return the hotel details based on id of hotel")
	public ResponseEntity<?> getHotelById(@ApiParam(value = "Param is a hotel id") @PathVariable Integer id)
	{
		Hotel hotel = service.fetchHotelById(id);
		return new ResponseEntity<>(hotel,HttpStatus.OK);
	}
	
	@GetMapping(value = "/hotel/{id}/room/{rid}")
	@ApiOperation(value = "Returns the rooms details based on hotel and room id")
	@ApiResponse(code = 200, message = "Response generated successfully")
	public ResponseEntity<?> getRoomByHotelId(@ApiParam(value = "hotel id") @PathVariable Integer id,@ApiParam(value = "room id") @PathVariable Integer rid)
	{
		Rooms rooms = service.fetchRoomByHotelIdAndRoomId(id, rid);
		return ResponseEntity.status(HttpStatus.OK).body(rooms);
	}
	
	@PostMapping(value = "/hotel/add")
	@ApiOperation(value = "Add new hotel details to the database")
	public  ResponseEntity<?> addHotel(@Valid @RequestBody Hotel hotel)
	{
		String message = service.addHotel(hotel);
		return ResponseEntity.status(HttpStatus.CREATED).body(message);
	}
	
	@PutMapping(value = "/hotel/update")
	@ApiOperation(value = "Update the hotel details")//customizing the description
	@ApiResponse(code = 200, message = "Response generated successfully")//customizing the status code and message
	public ResponseEntity<?> updateHotel(@RequestBody Hotel hotel)
	{
		String message = service.updateHotel(hotel);
		return ResponseEntity.status(HttpStatus.OK).body(message);
	}
	
	@DeleteMapping(value = "/hotel/{hid}/room/{rid}")
	public ResponseEntity<Void> deleteRoom(@PathVariable Integer hid,@PathVariable Integer rid)
	{
		service.deleteRoomByHotelAndRoomId(hid, rid);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@DeleteMapping(value = "/hotel/delete/{id}")
	public ResponseEntity<Void> deleteHotel(@PathVariable Integer id)
	{
		service.deleteHotel(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
