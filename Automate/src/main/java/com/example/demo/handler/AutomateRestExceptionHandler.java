package com.example.demo.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.exception.AutomateException;

@RestControllerAdvice
public class AutomateRestExceptionHandler {

	@ExceptionHandler(value = AutomateException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorMessage automatRestException(Exception exception) {
		return new ErrorMessage(exception.getMessage());
	}

	@ExceptionHandler(value = NullPointerException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorMessage nullRestException(Exception exception) {
		return new ErrorMessage(exception.getCause().toString());
	}
}
