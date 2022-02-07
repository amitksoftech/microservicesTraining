package com.synechron;

import java.time.Instant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class HelloUtils {
	private static Logger logger = LoggerFactory.getLogger(HelloUtils.class);

	public void crazy() {
		logger.info("crazy() called at {}", Instant.now().toString());
	}
}
