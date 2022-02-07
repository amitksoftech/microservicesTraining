package com.synechron;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalcController {
	@Autowired
	private CalcService calcService;
	
	@PostMapping("/add") 
	public long computeSum(@RequestParam long num1, @RequestParam long num2) {
		return calcService.add(num1, num2);
	}
	
	@PostMapping("/subtract") 
	public long computeDiff(@RequestParam long num1, @RequestParam long num2) {
		return calcService.subtract(num1, num2);
	}
}
