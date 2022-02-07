package com.synechron;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {

	@Autowired
	private GreetService greetService;
	
	
	@GetMapping("/hi/{name}")
	public String hi(@PathVariable String name) {
		return greetService.hi(name);
	}
	
	@GetMapping("/bye/{name}")
	public String bye(@PathVariable String name) {
		return greetService.bye(name);
	}
	
	
}
