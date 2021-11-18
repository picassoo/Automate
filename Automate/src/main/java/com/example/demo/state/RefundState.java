package com.example.demo.state;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.example.demo.exception.AutomateException;
import com.example.demo.handler.SuccessMessage;
import com.example.demo.model.Context;
import com.example.demo.model.Receipt;

@Component
public class RefundState implements AutomateState {

	private static ApplicationContext appContext;

	@Autowired
	public void context(ApplicationContext context) {
		RefundState.appContext = context;
	}

	@Override
	public SuccessMessage selectConsumable(AutomateContext context) throws AutomateException {
		throw new AutomateException("Payment was completed succesfully. Please get refund.");

	}

	@Override
	public SuccessMessage enterQuantityOfConsumable(AutomateContext context) throws AutomateException {
		throw new AutomateException("Payment was completed succesfully. Please get refund.");

	}

	@Override
	public SuccessMessage selectPaymentType(AutomateContext context) throws AutomateException {
		throw new AutomateException("Payment was completed succesfully. Please get refund.");

	}

	@Override
	public double refundPayment(AutomateContext context) throws AutomateException {

		Context currentContext = context.getCurrentContext();
		Context temporaryContext = context.getTemporaryContext();

		Optional<Double> money = Optional.of(temporaryContext.getMoney());

		if (money.isPresent()) {

			currentContext.setMoney(money.get());
			/*
			 * No need to check consumable and amount aren't empty. Early state of automate
			 * guarantees that those attributes aren't empty.
			 */
			context.getCurrentContext().setRefund(currentContext.getPayment().pay(currentContext.getMoney(),
					currentContext.getConsumable().getPrice() * currentContext.getAmount()));
			context.setState(appContext.getBean(ReceiptState.class));
		} else {
			throw new AutomateException("You must be choose consumable. ");
		}

		return currentContext.getRefund();

	}

	@Override
	public Receipt giveReceipt(AutomateContext context) throws AutomateException {
		throw new AutomateException("Payment was completed succesfully. Please get refund. ");
	}

}
