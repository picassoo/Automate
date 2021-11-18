package com.example.demo.exception;

public class AutomateException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AutomateException(String message) {
		super(message);
	}

	public AutomateException(String message, Throwable err) {
		super(message, err);
	}
}
