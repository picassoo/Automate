package com.example.demo.model.consumable;

import com.example.demo.exception.AutomateException;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public abstract class Slot<T extends Consumable> {

	@Getter
	@Setter
	private T consumable;
	@Getter
	private int amount;

	public void reduceAmount(int quantity) throws AutomateException {
		if (amount > 0) {
			if (amount < quantity)
				throw new AutomateException("Your order of amount of product exceeds amount of product");
			else
				amount -= quantity;
		} else {
			throw new AutomateException("These slot is empty.Select another one");
		}
	}
}
