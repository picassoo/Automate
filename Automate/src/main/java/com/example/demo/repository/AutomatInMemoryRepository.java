package com.example.demo.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.demo.exception.AutomateException;
import com.example.demo.model.consumable.ColdDrink;
import com.example.demo.model.consumable.Consumable;
import com.example.demo.model.consumable.Drink;
import com.example.demo.model.consumable.DrinkSlot;
import com.example.demo.model.consumable.Food;
import com.example.demo.model.consumable.FoodSlot;
import com.example.demo.model.consumable.HotDrink;
import com.example.demo.model.consumable.Slot;

@Component
public class AutomatInMemoryRepository {

	private static List<Slot<? extends Consumable>> immutableSlots;

	static {
		List<Slot<? extends Consumable>> slots = new ArrayList<Slot<? extends Consumable>>();

		slots.add(generateFood("gofret", 1.5, 4));
		slots.add(generateFood("gofret", 1.5, 4));
		slots.add(generateFood("gofret", 1.5, 4));
		slots.add(generateFood("gofret", 1.5, 4));
		slots.add(generateFood("gofret", 1.5, 4));
		slots.add(generateFood("gofret", 1.5, 4));
		slots.add(generateFood("gofret", 1.5, 4));
		slots.add(generateFood("gofret", 1.5, 4));
		slots.add(generateFood("gofret", 1.5, 4));
		slots.add(generateFood("gofret", 1.5, 4));
		slots.add(generateFood("gofret", 1.5, 4));
		slots.add(generateFood("gofret", 1.5, 4));
		slots.add(generateFood("gofret", 1.5, 4));
		slots.add(generateFood("gofret", 1.5, 4));
		slots.add(generateFood("gofret", 1.5, 4));
		slots.add(generateFood("gofret", 1.5, 4));
		slots.add(generateFood("gofret", 1.5, 4));
		slots.add(generateFood("gofret", 1.5, 4));
		slots.add(generateFood("gofret", 1.5, 4));
		slots.add(generateFood("gofret", 1.5, 4));

		slots.add(generateColdDrink("ice tea", 1.5, 4));
		slots.add(generateColdDrink("ice coffee", 1.5, 4));
		slots.add(generateColdDrink("latte", 1.5, 4));
		slots.add(generateColdDrink("cola", 1.5, 4));
		slots.add(generateColdDrink("gofret", 1.5, 4));

		slots.add(generateHotDrink("gofret", 1.5, 4));
		slots.add(generateHotDrink("gofret", 1.5, 4));
		slots.add(generateHotDrink("gofret", 1.5, 4));
		slots.add(generateHotDrink("gofret", 1.5, 4));
		slots.add(generateHotDrink("gofret", 1.5, 4));

		immutableSlots = Collections.unmodifiableList(slots);

	}

	public static FoodSlot generateFood(String name, double price, int amount) {
		Food food = new Food(name, price);
		FoodSlot foodSlot = new FoodSlot(food, amount);
		return foodSlot;
	}

	public static DrinkSlot generateHotDrink(String name, double price, int amount) {
		Drink drink = new HotDrink(name, price);
		DrinkSlot drinkSlot = new DrinkSlot(drink, amount);
		return drinkSlot;
	}

	public static DrinkSlot generateColdDrink(String name, double price, int amount) {
		Drink drink = new ColdDrink(name, price);
		DrinkSlot drinkSlot = new DrinkSlot(drink, amount);
		return drinkSlot;
	}

	public Consumable findById(int id) {
		return immutableSlots.get(id).getConsumable();
	}

	public Consumable getById(int id, int amount) throws AutomateException {
		Slot<?> slot = immutableSlots.get(id);
		slot.reduceAmount(amount);

		return immutableSlots.get(id).getConsumable();
	}

	public List<Slot<? extends Consumable>> getStatSlot() {
		return immutableSlots;
	}

	public List<Consumable> findAllConsumable() {
		return immutableSlots.stream().map(s -> s.getConsumable()).collect(Collectors.toList());
	}
}
