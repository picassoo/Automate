package com.example.demo.model.payment;

import org.springframework.stereotype.Component;

@Component
public class Paper implements Cash {

	@Override
	public double pay(double money, double price) {
		// TODO Auto-generated method stub
		return money - price;
	}

	@Override
	public PaymentType getPaymentType() {
		// TODO Auto-generated method stub
		return PaymentType.Paper;
	}

}
