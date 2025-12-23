package com.example.SpringAi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {
	
	@Autowired
	ChatService service;
	
	@RequestMapping("/chat")
	public String getResponse(@RequestParam String prompt) {
		
		return service.getresponse(prompt);
		
	}

}
