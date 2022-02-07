package com.synechron;

import java.time.Instant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

	@Autowired
	private HelloUtils helloUtils;
	
	private static Logger logger = LoggerFactory.getLogger(HelloService.class);

	public String doSomething() {
		logger.info("doSomething() called at {}", Instant.now().toString());
		helloUtils.crazy();
		return "Hey there";
	}
}
