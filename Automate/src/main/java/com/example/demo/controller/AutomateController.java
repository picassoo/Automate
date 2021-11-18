package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.AutomateException;
import com.example.demo.handler.SuccessMessage;
import com.example.demo.model.Receipt;
import com.example.demo.model.consumable.Consumable;
import com.example.demo.model.consumable.Slot;
import com.example.demo.model.payment.PaymentType;
import com.example.demo.service.AutomateService;

@RestController
@RequestMapping("/automat/v1")
public class AutomateController {

	@Autowired
	private AutomateService automatService;

	@GetMapping("/consumables")
	public List<Consumable> allConsumables() {
		return automatService.getAllConsumable();
	}

	@GetMapping("/consumable")
	public Consumable getConsumable(@RequestParam int id) {
		return automatService.getConsumable(id);
	}

	@GetMapping("/slot")
	public List<Slot<? extends Consumable>> getAllSlot() {
		return automatService.getAllSlots();
	}

	@GetMapping("/payments")
	public List<PaymentType> getPayments() {
		return automatService.getAllPaymentType();
	}

	@GetMapping("/select")
	public SuccessMessage selectProduct(@RequestParam int id) throws AutomateException {
		return automatService.selectProduct(id);
	}

	@GetMapping("/amount")
	public SuccessMessage enterAmountOfProduct(@RequestParam int amount) throws AutomateException {
		return automatService.enterAmountOfProduct(amount);
	}

	@GetMapping("/payment")
	public SuccessMessage selectPayment(@RequestParam String paymentType) throws AutomateException {
		return automatService.pay(PaymentType.valueOf(paymentType));

	}

	@GetMapping("/refund")
	public Double refundPayment(@RequestParam Double money) throws AutomateException {
		return automatService.refund(money);
	}

	@GetMapping("/receipt")
	public Receipt receiptPayment() throws AutomateException {
		return automatService.receipt();
	}
}
