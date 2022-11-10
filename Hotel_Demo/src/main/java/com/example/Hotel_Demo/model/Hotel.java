package com.example.Hotel_Demo.model;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.example.Hotel_Demo.entities.RoomsEntity;

import lombok.Data;

@Data
public class Hotel implements Serializable {

	@NotNull
	private Integer id;

	@NotEmpty
	private String name;

	@NotNull
	private Integer zipCode;

	@NotEmpty
	private String description;

	private boolean isActive;

	private List<Rooms> rooms;
}
