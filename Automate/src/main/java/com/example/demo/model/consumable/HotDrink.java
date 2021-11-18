package com.example.demo.model.consumable;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

public class HotDrink implements Drink {

	@NonNull
	private String name;
	@Setter
	@Getter
	private int sugarLevel = 0;
	private double price;

	public HotDrink(String name, double price) {
		this.name = name;
		this.price = price;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return price;
	}

}
