package com.example.demo.state;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.Context;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Getter
@Setter
@NoArgsConstructor
public class AutomateContext {
	
	/*
	 * Default parameter is Select State.
	 */
	private AutomateState state = new SelectState();
	@Autowired
	private Context temporaryContext;
	@Autowired
	private Context currentContext;

}
