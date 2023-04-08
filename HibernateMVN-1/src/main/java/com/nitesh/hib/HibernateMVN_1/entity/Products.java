package com.nitesh.hib.HibernateMVN_1.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pd")
public class Products {
	@Id
	@Column(name="pid")
	private int id;
	
	@Column(name="pname")
	private String name;
	
	@Column(name="pqty")
	private int qty;
	
	@Column(name="pcode")
	private String code;
	
	@Column(name="pprice")
	private double price;
	

	public Products(int id, String name, int qty, String code, double price) {
		
		this.id = id;
		this.name = name;
		this.qty = qty;
		this.code = code;
		this.price = price;
	}

	public Products() {
		
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

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Products [id=" + id + ", name=" + name + ", qty=" + qty + ", code=" + code + ", price=" + price + "]";
	}
	
	
	
	
	

}
