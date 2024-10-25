package com.assessment.checkouts;

// Class which contain offer details
public class item {
	public String name;
	public Integer quantity;
	public Double price;
	
	public item(String name, Integer quantity, Double price){
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}
}