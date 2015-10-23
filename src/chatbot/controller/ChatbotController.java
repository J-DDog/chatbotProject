package chatbot.controller;

import chatbot.model.Chatbot;
import chatbot.view.ChatbotView;

public class ChatbotController 
{
	
	private Chatbot myBot;
	private ChatbotView myDisplay;
	private String userName;
	
	public ChatbotController()
	{
	
		myDisplay = new ChatbotView();
		userName = myDisplay.getResponce("Enter Username:");
		myBot = new Chatbot(userName);
		
	}
	
	public void start()
	{
		myDisplay.displayMessage("Hello " + myBot.getUserName());
	}
	
}
