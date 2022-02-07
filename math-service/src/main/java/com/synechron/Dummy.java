package com.synechron;

import javax.annotation.PostConstruct;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
public class Dummy {
	
	@PostConstruct
	public void print() {
		System.out.println("****Dummy instance created");
	}

}
