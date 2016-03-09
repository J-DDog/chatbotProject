package chatbot.model;

import java.util.ArrayList;

import chatbot.controller.ChatbotController;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

/**
 * @author jker3169
 * @version 0.5
 * 
 * this is the twitter interaction class
 * in this class I use what i've learned about api's to
 * 
 */
public class CTECTwitter
{
	private ChatbotController baseController;	
	private Twitter chatbotTwitter;
	
	private ArrayList<Status> statusList;
	private ArrayList<String> wordList;
	
	public CTECTwitter(ChatbotController baseController)
	{		
		this.baseController = baseController;
		chatbotTwitter = TwitterFactory.getSingleton();
		
		statusList = new ArrayList<Status>();
		wordList = new ArrayList<String>();
		
		
		
	}
	
	public void sendTweet(String tweet)
	{
		try
		{
			chatbotTwitter.updateStatus("I, Jared, just tweeted from my Java Chatbot program!"
					+ " #APCSRocks @CTECNow Thanks @cscheerleader & @codyhenrichsen!");
		}
		catch (TwitterException error)
		{
			baseController.handleError(error.getErrorMessage());
		}
		
	}
	
}
