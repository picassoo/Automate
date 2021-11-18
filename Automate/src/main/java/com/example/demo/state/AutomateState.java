package com.example.demo.state;

import com.example.demo.exception.AutomateException;
import com.example.demo.handler.SuccessMessage;
import com.example.demo.model.Receipt;

public interface AutomateState {

	SuccessMessage selectConsumable(AutomateContext context) throws AutomateException;;

	SuccessMessage enterQuantityOfConsumable(AutomateContext context) throws AutomateException;

	SuccessMessage selectPaymentType(AutomateContext context) throws AutomateException;;

	double refundPayment(AutomateContext context) throws AutomateException;;

	Receipt giveReceipt(AutomateContext context) throws AutomateException;;

}
