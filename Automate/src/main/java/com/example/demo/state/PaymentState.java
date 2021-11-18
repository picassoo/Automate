package com.example.demo.state;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.example.demo.exception.AutomateException;
import com.example.demo.handler.SuccessMessage;
import com.example.demo.model.Receipt;
import com.example.demo.model.payment.Payment;

@Component
public class PaymentState implements AutomateState {

	private static ApplicationContext appContext;

	@Autowired
	public void context(ApplicationContext context) {
		PaymentState.appContext = context;
	}

	@Override
	public SuccessMessage selectConsumable(AutomateContext context) throws AutomateException {
		throw new AutomateException("You should be choosed payment type ");
	}

	@Override
	public SuccessMessage enterQuantityOfConsumable(AutomateContext context) throws AutomateException {
		throw new AutomateException("You should be choosed payment type ");

	}

	@Override
	public SuccessMessage selectPaymentType(AutomateContext context) throws AutomateException {

		Optional<Payment> payment = Optional.of(context.getTemporaryContext().getPayment());

		if (payment.isPresent()) {
			context.getCurrentContext().setPayment(payment.get());
			context.setState(appContext.getBean(RefundState.class));
		} else {
			throw new AutomateException("You already enter amount of consumable or miss some arguments. ");
		}
		return new SuccessMessage("Consumable selected succesfully.", context.getCurrentContext());

	}

	@Override
	public double refundPayment(AutomateContext context) throws AutomateException {
		throw new AutomateException("You must be enterred payment type before approving payment. ");

	}

	@Override
	public Receipt giveReceipt(AutomateContext context) throws AutomateException {
		throw new AutomateException("You  must be enterred payment type before giving receipt. ");

	}

}
