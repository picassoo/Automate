package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.example.demo.model.Context;

@Configuration
public class AutomateConfiguration {

	@Bean
	@Scope(value = "prototype")
	public Context getContext() {
		return new Context();
	}



}
