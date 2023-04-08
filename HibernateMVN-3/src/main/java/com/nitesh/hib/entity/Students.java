package com.nitesh.hib.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Transient;

@Entity
public class Students {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "students_ID")
	private int id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "CITY")
	private String city;
	
	@Column( name = "STREET")
	private String street;
	
	@Transient
	private double x;
	
	@Lob
	@Column(columnDefinition = "LONGBLOB")
	private byte[] file;
	
	
	@Lob
	@Column(columnDefinition = "LONGBLOB")
	private byte[] vedio;
	 
	 

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	
	public byte[] getVedio() {
		return vedio;
	}

	public void setVedio(byte[] vedio) {
		this.vedio = vedio;
	}
	

	public Students() {
		
	}
	
	

}
