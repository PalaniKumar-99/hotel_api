package com.example.Hotel_Demo.advice;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.Hotel_Demo.exception.HotelNotFoundException;
import com.example.Hotel_Demo.exception.RoomNotFoundException;

@RestControllerAdvice
public class HotelControllerAdvice 
{
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleRequestBody(MethodArgumentNotValidException ex)
	{
		List<FieldError> lsterror = ex.getBindingResult().getFieldErrors();
		String errorMessage = lsterror.stream().map(fieldError -> fieldError.getField()+"-"+fieldError.getDefaultMessage()).sorted().collect(Collectors.joining(", "));
		return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(HotelNotFoundException.class)
	public ResponseEntity<?> hotelNotFound(HotelNotFoundException ex)
	{
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(RoomNotFoundException.class)
	public ResponseEntity<?> roomNotFound(RoomNotFoundException ex)
	{
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	}
}
