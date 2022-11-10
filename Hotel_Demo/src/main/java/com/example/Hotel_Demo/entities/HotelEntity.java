package com.example.Hotel_Demo.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name = "Hotel")
@Data
public class HotelEntity 
{
	@Id
	private Integer id;
	
	@Column(length = 30)
	private String name;
	
	
	private Integer zipCode;
	
	@Column(length = 50)
	private String description;
	
	private boolean isActive;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "Hotel_id")
	private List<RoomsEntity> rooms;
}
