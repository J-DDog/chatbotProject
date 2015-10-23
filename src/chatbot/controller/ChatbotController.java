package chatbot.controller;

import chatbot.model.Chatbot;
import chatbot.view.ChatbotView;

public class ChatbotController 
{
	
	private Chatbot myBot;
	private ChatbotView myDisplay;
	private String userName = "Guest";
	
	public ChatbotController()
	{
		
		myDisplay = new ChatbotView();
		myBot = new Chatbot(myDisplay.getResponce("Enter Username:"));
	}
	
	public void start()
	{
		
	}
	
}
