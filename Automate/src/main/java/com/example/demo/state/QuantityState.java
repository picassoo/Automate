package com.example.demo.state;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.example.demo.exception.AutomateException;
import com.example.demo.handler.SuccessMessage;
import com.example.demo.model.Receipt;

@Component
public class QuantityState implements AutomateState {

	private static ApplicationContext appContext;

	@Autowired
	public void context(ApplicationContext context) {
		QuantityState.appContext = context;
	}

	@Override
	public SuccessMessage selectConsumable(AutomateContext context) throws AutomateException {
		throw new AutomateException("You have already selected consumable. Please enter amount of consumable. ");

	}

	@Override
	public SuccessMessage enterQuantityOfConsumable(AutomateContext context) throws AutomateException {
		Optional<Integer> amount = Optional.of(context.getTemporaryContext().getAmount());

		if (amount.isPresent()) {
			context.getCurrentContext().setAmount(amount.get());
			context.setState(appContext.getBean(PaymentState.class));
		} else {
			throw new AutomateException("You already enter amount of consumable or miss some arguments. ");
		}
		return new SuccessMessage("Amount of consumable entered succesfully.", context.getCurrentContext());
	}

	@Override
	public SuccessMessage selectPaymentType(AutomateContext context) throws AutomateException {
		throw new AutomateException("You must be enter amount of consumable before selecting payment type. ");

	}

	@Override
	public double refundPayment(AutomateContext context) throws AutomateException {
		throw new AutomateException("You must be enter amount of consumable before approving payment. ");

	}

	@Override
	public Receipt giveReceipt(AutomateContext context) throws AutomateException {
		throw new AutomateException("You must be enter amount of consumable before giving receipt. ");

	}

}
