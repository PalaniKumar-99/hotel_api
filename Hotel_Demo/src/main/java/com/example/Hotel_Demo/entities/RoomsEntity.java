package com.example.Hotel_Demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Rooms")
@Data
public class RoomsEntity {

	@Id
	private Integer id;
	
	@Column(length = 20)
	private String displayName;
	
	private Integer quantity;
	
	private Double price;
}
