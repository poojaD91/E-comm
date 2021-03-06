package com.example.demo.productservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="gear_details")
public class ProductFanGear {
	
	@Id
	@GeneratedValue
	private int gearId;
	private String gearName;
	private int quantity;
	private float price;
	
	@ManyToOne
    @JoinColumn(name="gameId", nullable=false)
	private ProductVideoGame prodVG;
	
	public ProductFanGear() {}

	/*
	 * public ProductFanGear(int gearId, String gearName, int quantity,
	 * ProductVideoGame prodVG) { this.gearId = gearId; this.gearName = gearName;
	 * this.quantity = quantity; this.prodVG = prodVG; }
	 */
	
	public ProductFanGear(int gearId, String gearName, int quantity,float price) {
		this.gearId = gearId;
		this.gearName = gearName;
		this.quantity = quantity;
		this.price = price;
		
	}

	public int getgearId() {
		return gearId;
	}

	public void setgearId(int gearId) {
		this.gearId = gearId;
	}

	public String getgearName() {
		return gearName;
	}

	public void setgearName(String gearName) {
		this.gearName = gearName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}
