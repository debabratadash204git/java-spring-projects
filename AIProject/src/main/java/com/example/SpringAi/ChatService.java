package com.example.SpringAi;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.ai.chat.prompt.DefaultChatOptionsBuilder;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatService {
	
	@Autowired
	private ChatModel chatmodel;
	
//	@Autowired
//	private ChatOptions chatOptions;
	
	
	public String getresponse(String promptText) {
		Prompt prompt = new Prompt(promptText);
		
		ChatResponse response = chatmodel.call(prompt);
		return response.getResult().getOutput().getText();
	}
	
	  public String getResponseFromCustomOptions(String promptText) {
	        ChatOptions chatOptions = new DefaultChatOptionsBuilder()
	                .model("global.amazon.nova-2-lite-v1:0")
	                .topK(10)
	                .temperature(0.1)
	                .build();


	       return ChatClient.create(this.chatmodel)
	                .prompt(promptText)
	                .options(chatOptions)
	                .call()
	                .content();
	    }

}
