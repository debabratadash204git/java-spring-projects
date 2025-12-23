package com.example.CircuitBreaker;

import org.springframework.stereotype.Service;

@Service
public class FallbackService {
	
	public String fallBackMethod() {
		return "Fallback response: Service temporarily unavailable.";
	}
}
