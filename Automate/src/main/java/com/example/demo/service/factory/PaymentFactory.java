package com.example.demo.service.factory;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.payment.Payment;
import com.example.demo.model.payment.PaymentType;

@Component
public class PaymentFactory {

	private final Map<PaymentType, Payment> paymentMap = new EnumMap<>(PaymentType.class);

	@Autowired
	private PaymentFactory(List<Payment> payments) {
		for (Payment payment : payments) {
			paymentMap.put(payment.getPaymentType(), payment);
		}
	}

	public Payment getViewer(PaymentType paymentType) {
		Payment payment = paymentMap.get(paymentType);
		if (payment == null) {
			throw new IllegalArgumentException();
		}
		return payment;
	}

	public List<PaymentType> getPayments() {
		return paymentMap.values().stream().map(p -> p.getPaymentType()).collect(Collectors.toList());
	}
}
