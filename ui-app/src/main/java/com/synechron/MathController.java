package com.synechron;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

	@Autowired
	private MathService mathService;
	
	@Autowired
	private CircuitBreakerFactory cbFactory;
	
	@PostMapping("/square") 
	public String computeSquare(@RequestParam long num) {
		return cbFactory.create("mathCircuit").run(
			() -> {
				System.out.println("Checking for original source");
				return mathService.square(num) + "";
			},
			(t) -> {
				System.out.println("Calling fallback");
				return "Oops! Service is down. Please try later";
			}
		);
	}
	
	@PostMapping("/cube") 
	public String computeCube(@RequestParam long num) {
		return cbFactory.create("mathCircuit").run(
				() -> {
					return mathService.cube(num) + "";
				},
				(t) -> {
					return "Oops! Service is down. Please try later";
				}
			);
	}
}
