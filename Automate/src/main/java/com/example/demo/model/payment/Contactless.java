package com.example.demo.model.payment;

import org.springframework.stereotype.Component;

@Component
public class Contactless implements CreditCard {

	@Override
	public double pay(double money, double price) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PaymentType getPaymentType() {
		// TODO Auto-generated method stub
		return PaymentType.Contactless;
	}

}
