package com.synechron;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CalcService {

	@Value("${gateway.service.url}")
	private String gatewayServiceUrl;

	@Value("${service.url.sum}")
	private String sumServiceurl;
	
	@Value("${service.url.diff}")
	private String diffServiceurl;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public long add(long number1, long number2) {
		String url = gatewayServiceUrl + "/" + sumServiceurl + "/" + number1 + "/" + number2;
		ResponseEntity<Long> responseEntity = restTemplate.getForEntity(url, Long.class);
		return responseEntity.getBody();
	}
	
	public long subtract(long number1, long number2) {
		String url = gatewayServiceUrl + "/" + diffServiceurl + "/" + number1 + "/" + number2;
		ResponseEntity<Long> responseEntity = restTemplate.getForEntity(url, Long.class);
		return responseEntity.getBody();
	}

}
