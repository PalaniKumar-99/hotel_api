package com.example.Hotel_Demo.model;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class Rooms implements Serializable
{

	@NotNull
	private Integer id;
	@NotEmpty
	private String displayName;
	@NotNull
	private Integer quantity;
	@NotNull
	private Double price;
}
