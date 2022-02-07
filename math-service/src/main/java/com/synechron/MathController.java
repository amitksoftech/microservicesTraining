package com.synechron;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/math")
@Api("Math operations")
public class MathController {
	private static Logger logger = LoggerFactory.getLogger(MathController.class);

	@ApiOperation(value = "Square of a number")
	@ApiResponse(code = 200, response = Long.class, message = "Square is ")
	@GetMapping("/square/{num}")
	public HttpEntity<Long> computeSquare(@PathVariable @ApiParam(example = "100") long num) {
		logger.info("computerSquare called for {}", num);
		return new ResponseEntity<>(num * num, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Cube of a number")
	@GetMapping("/cube/{num}")
	public HttpEntity<Long> computeCube(@PathVariable @ApiParam(example = "100") long num) {
		logger.info("computerCube called for {}", num);
		return new ResponseEntity<>(num * num * num, HttpStatus.OK);
	}
	
}
