package com.example.demo.handler;

import com.example.demo.model.Context;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SuccessMessage {

	private String message;
	private Context context;
}
