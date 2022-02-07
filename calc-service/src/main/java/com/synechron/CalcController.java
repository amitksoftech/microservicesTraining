package com.synechron;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calc")
public class CalcController {

	@GetMapping("/add/{a}/{b}")
	public HttpEntity<Long> add(@PathVariable long a, @PathVariable long b) {
		return new ResponseEntity<>(a + b, HttpStatus.OK);
	}
	
	@GetMapping("/subtract/{a}/{b}")
	public HttpEntity<Long> subtract(@PathVariable long a, @PathVariable long b) {
		return new ResponseEntity<>(a - b, HttpStatus.OK);
	}

}
