package com.example.CircuitBreaker;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class ExternalApiService {
	
	public String callExternalApi() {
		
		if(new Random().nextBoolean())
			throw new RuntimeException("External API failed");
		
		return "API Successful";
	}

}
