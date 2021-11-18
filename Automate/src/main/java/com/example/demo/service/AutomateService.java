package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.AutomateException;
import com.example.demo.handler.SuccessMessage;
import com.example.demo.model.Receipt;
import com.example.demo.model.consumable.Consumable;
import com.example.demo.model.consumable.Slot;
import com.example.demo.model.payment.PaymentType;
import com.example.demo.repository.AutomatInMemoryRepository;
import com.example.demo.service.factory.PaymentFactory;
import com.example.demo.state.AutomateContext;

@Service("automatService")
public class AutomateService {

	@Autowired
	private AutomateContext automatContext;
	@Autowired
	private PaymentFactory factory;
	@Autowired
	private AutomatInMemoryRepository repository;

	public List<Consumable> getAllConsumable() {
		// TODO Auto-generated method stub
		return repository.findAllConsumable();
	}

	public Consumable getConsumable(int id) {
		return repository.findById(id);
	}

	public List<Slot<? extends Consumable>> getAllSlots() {
		// TODO Auto-generated method stub
		return repository.getStatSlot();
	}

	public List<PaymentType> getAllPaymentType() {
		return factory.getPayments();
	}

	public SuccessMessage selectProduct(int id) throws AutomateException {
		automatContext.getTemporaryContext().setConsumable(repository.findById(id));
		return automatContext.getState().selectConsumable(automatContext);

	}

	public SuccessMessage enterAmountOfProduct(int amount) throws AutomateException {
		automatContext.getTemporaryContext().setAmount(amount);
		return automatContext.getState().enterQuantityOfConsumable(automatContext);

	}

	public SuccessMessage pay(PaymentType paymentType) throws AutomateException {
		automatContext.getTemporaryContext().setPayment(factory.getViewer(paymentType));
		System.out.println(automatContext.getState());
		return automatContext.getState().selectPaymentType(automatContext);
	}

	public Double refund(Double money) throws AutomateException {
		automatContext.getTemporaryContext().setMoney(money);
		return automatContext.getState().refundPayment(automatContext);
	}

	public Receipt receipt() throws AutomateException {
		return automatContext.getState().giveReceipt(automatContext);
	}
}
