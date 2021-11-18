package com.example.demo.model;

import com.example.demo.model.consumable.Consumable;
import com.example.demo.model.payment.Payment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Context {

	private Consumable consumable;
	private Double money;
	private int amount;
	private Payment payment;
	private double refund;

}
