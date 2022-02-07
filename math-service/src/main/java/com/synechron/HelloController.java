package com.synechron;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class HelloController {
	
	@Autowired
	private Dummy dummy;
	
	@PostConstruct
	public void printMessage() {
		System.out.println("********* HelloController instance created " + this + " ******");
		System.out.println(dummy);
	}
	
	@Value("${welcome}")
	private String welcome;
	
	@GetMapping("/welcome")
	public String getWelcomeMessage() {
		return welcome;
	}

}
