package com.example.demo.state;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.example.demo.exception.AutomateException;
import com.example.demo.handler.SuccessMessage;
import com.example.demo.model.Context;
import com.example.demo.model.Receipt;

@Component
public class ReceiptState implements AutomateState {
	private static ApplicationContext appContext;

	@Autowired
	public void context(ApplicationContext context) {
		ReceiptState.appContext = context;
	}

	@Override
	public SuccessMessage selectConsumable(AutomateContext context) throws AutomateException {
		throw new AutomateException("Please take your receipt ");
	}

	@Override
	public SuccessMessage enterQuantityOfConsumable(AutomateContext context) throws AutomateException {
		throw new AutomateException("Please take your receipt ");

	}

	@Override
	public SuccessMessage selectPaymentType(AutomateContext context) throws AutomateException {
		throw new AutomateException("Please take your receipt ");

	}

	@Override
	public double refundPayment(AutomateContext context) throws AutomateException {
		throw new AutomateException("Please take your receipt ");

	}

	@Override
	public Receipt giveReceipt(AutomateContext context) throws AutomateException {

		Context currentContext = context.getCurrentContext();

		Receipt receipt = new Receipt(currentContext.getConsumable().getName(),
				currentContext.getPayment().getPaymentType().toString(), currentContext.getAmount(),
				currentContext.getRefund());
		/**
		 * When automate gives receipt, stage of automate starts again from state of
		 * selection. Before its starts again from select state, context attributes
		 * should be initialized to null.
		 */
		context.setTemporaryContext(new Context());
		context.setCurrentContext(new Context());
		context.setState(appContext.getBean(SelectState.class));

		return receipt;

	}

}
