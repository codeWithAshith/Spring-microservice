package com.codeWithAshith.microservices.Currencyexchangeservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;

@RestController
public class CircuitBreakerController {

	@GetMapping("/sample-api")
// calls three times
//	@Retry(name="default")
//	@Retry(name="sample-api")
//	@Retry(name="sample-api", fallbackMethod = "hardcodedResponse")
//	@CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")
//	@RateLimiter(name = "default")
	// 10s => 10000 calls to the sample api
	@Bulkhead(name="sample-api")
	public String sampleApi() {
		System.out.println("Sample api call received");
//		ResponseEntity<String> responseEntity = new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url",
//				String.class);
//		return responseEntity.getBody();
		return "sample-API";
	}

	public String hardcodedResponse(Exception ex) {
		return "fallback-response";
	}

}
