package com.synechron;


import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class GreetService {

	@Cacheable(value = "message", key = "#name")
	public String hi(String name) {
		//Assume this message needs to be fetched from a DB
		//Let's simulate a delay
		try {
			System.out.println("*** Fetching the message for " + name + " from DB");
			Thread.sleep(5 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "Hello " + name;
	}
	
	@CacheEvict(value = "message", key = "#name")
	public String bye(String name) {
		return "Bye bye " + name;
	}
}
