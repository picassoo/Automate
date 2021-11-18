package com.example.demo.model.consumable;

import lombok.AllArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
public class Food implements Consumable {

	@NonNull
	private String name;

	private double price;

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
