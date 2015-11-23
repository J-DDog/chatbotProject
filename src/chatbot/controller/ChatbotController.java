package chatbot.controller;

import chatbot.model.*;
import chatbot.view.*;

public class ChatbotController 
{
	private NotePlayer note;
	private Chatbot myBot;


	private ChatbotView myDisplay;
	private ChatFrame baseFrame;
	private ChatPanel basePanel;
	private String userName;
	
	public ChatbotController()
	{
		
		note = new NotePlayer();
		note.start();
		
		myDisplay = new ChatbotView();
		userName = myDisplay.getResponce("Enter Username:");
		
		myBot = new Chatbot(userName);
		
		baseFrame = new ChatFrame(this);
		
	}
	
	public void start()
	{
//		myDisplay.displayMessage("Hello " + myBot.getUserName());
		chat();
	}
	
	private void chat()
	{
//		String conversation = myDisplay.getResponce("What would you like to talk about today?");
//		myBot.contentChecker(conversation);
//		while(myBot.lengthChecker(conversation))
//		{
//			conversation = myBot.processConversation(conversation);
//			conversation = myDisplay.getResponce(conversation);
//		}
	}
	
	private void shutDown()
	{
		
	}
	
	public NotePlayer getNote()
	{
		return note;
	}

	public void setNote(NotePlayer note)
	{
		this.note = note;
	}

	public Chatbot getMyBot()
	{
		return myBot;
	}

	public void setMyBot(Chatbot myBot)
	{
		this.myBot = myBot;
	}

//	public ChatbotView getMyDisplay()
//	{
//		return myDisplay;
//	}
//
//	public void setMyDisplay(ChatbotView myDisplay)
//	{
//		this.myDisplay = myDisplay;
//	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	
}
