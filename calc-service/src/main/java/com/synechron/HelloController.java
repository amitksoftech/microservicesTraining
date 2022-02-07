package com.synechron;

import java.time.Instant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	private static Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	@Autowired
	private HelloService helloService;

	@GetMapping("/hellocalc")
	public String hello() {
		logger.info("hello() called at {}", Instant.now().toString());
		String result = helloService.doSomething();
		return result;
	}
}
