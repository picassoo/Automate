package com.example.demo.model.payment;

public interface Payment {

	PaymentType getPaymentType();

	double pay(double money,double price);
}
