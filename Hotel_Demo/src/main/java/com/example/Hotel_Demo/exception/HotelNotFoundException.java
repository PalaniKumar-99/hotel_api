package com.example.Hotel_Demo.exception;

public class HotelNotFoundException extends RuntimeException
{
	public HotelNotFoundException()
	{
		super();
	}
	
	public HotelNotFoundException(String message)
	{
		super(message);
	}
}
