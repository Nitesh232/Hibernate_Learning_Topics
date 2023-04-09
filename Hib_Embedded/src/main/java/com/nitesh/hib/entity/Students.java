package com.nitesh.hib.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Students {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Students_ID")
	private int id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "Degree")
	private String standard;
	
	@Embedded
	@AttributeOverrides({@AttributeOverride(name = "courseName", column=@Column(name="Course_Name")),
						@AttributeOverride(name = "courseDuration", column=@Column(name="Course_Duration")),
						@AttributeOverride(name = "instructor", column=@Column(name="Course_Instructor"))
			
	})
	private Courses crs;
	
	@Embedded
	@AttributeOverrides({@AttributeOverride(name = "street", column=@Column(name="Street_Name")),
						 @AttributeOverride(name = "city", column=@Column(name="City_Name")),
						 @AttributeOverride(name = "state", column=@Column(name="State_Name")),
						 @AttributeOverride(name = "pinCode", column=@Column(name="Area_PinCode"))

	})
	private Address addr;

	
	
	public Students() {
		
	}

	public Students(int id, String name, String standard, Courses crs, Address addr) {
		this.id = id;
		this.name = name;
		this.standard = standard;
		this.crs = crs;
		this.addr = addr;
	}

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

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public Courses getCrs() {
		return crs;
	}

	public void setCrs(Courses crs) {
		this.crs = crs;
	}

	public Address getAddr() {
		return addr;
	}

	public void setAddr(Address addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "Students [id=" + id + ", name=" + name + ", standard=" + standard + ", crs=" + crs + ", addr=" + addr
				+ "]";
	}	

}
