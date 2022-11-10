package com.example.Hotel_Demo.exception;

public class RoomNotFoundException extends RuntimeException
{
	public RoomNotFoundException()
	{
		super();
	}
	public RoomNotFoundException(String message)
	{
		super(message);
	}
}
