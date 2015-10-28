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
		chat();
	}
	
	private void chat()
	{
		String conversation = myDisplay.getResponce("What would you like to talk about today?");
		while(myBot.lengthChecker(conversation))
		{
			if(myBot.contentChecker(conversation))
			{
				myDisplay.displayMessage("Wow I Had no idea you were interested in " + myBot.getContent());
			}
			conversation = myDisplay.getResponce(conversation);
		}
	}
	
	private void shutDown()
	{
		
	}
	
}
