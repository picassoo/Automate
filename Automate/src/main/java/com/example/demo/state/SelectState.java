package com.example.demo.state;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.example.demo.exception.AutomateException;
import com.example.demo.handler.SuccessMessage;
import com.example.demo.model.Receipt;
import com.example.demo.model.consumable.Consumable;

@Component
public class SelectState implements AutomateState {

	private static ApplicationContext appContext;

	@Autowired
	public void context(ApplicationContext context) {
		SelectState.appContext = context;
	}

	@Override
	public SuccessMessage selectConsumable(AutomateContext context) throws AutomateException {
		Optional<Consumable> consumable = Optional.of(context.getTemporaryContext().getConsumable());
		if (consumable.isPresent()) {
			context.getCurrentContext().setConsumable(consumable.get());
			context.setState(appContext.getBean(QuantityState.class));
		} else {
			throw new AutomateException("You must be choose consumable. ");
		}

		return new SuccessMessage("Consumable selected succesfully.", context.getCurrentContext());
	}

	@Override
	public SuccessMessage enterQuantityOfConsumable(AutomateContext context) throws AutomateException {
		throw new AutomateException("You must be choose consumable before entering amount of consumable. ");
	}

	@Override
	public SuccessMessage selectPaymentType(AutomateContext context) throws AutomateException {
		throw new AutomateException("You must be choose consumable before selecting payment type. ");

	}

	@Override
	public double refundPayment(AutomateContext context) throws AutomateException {
		throw new AutomateException("You must be choose consumable before refunding your money. ");

	}

	@Override
	public Receipt giveReceipt(AutomateContext context) throws AutomateException {
		throw new AutomateException("You must be choose consumable before giving receipt. ");
	}

}
