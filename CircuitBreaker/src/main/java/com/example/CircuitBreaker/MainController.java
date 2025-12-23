package com.example.CircuitBreaker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class MainController {
	
	private final ExternalApiService externalservice;
	private final FallbackService fallbackservice;
	
	public MainController(ExternalApiService externalservice, FallbackService fallbackservice) {
		
		this.externalservice = externalservice;
		this.fallbackservice = fallbackservice;
		// TODO Auto-generated constructor stub
		
	}
	
	@GetMapping("/call")
	@CircuitBreaker(name="externalApiCB", fallbackMethod="fallback")
	public String callApi() {
		return externalservice.callExternalApi();
	}
	
	public String fallback(Exception ex) {
		return fallbackservice.fallBackMethod();
	}

}
