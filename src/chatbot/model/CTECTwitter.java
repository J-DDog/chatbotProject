package chatbot.model;

import java.util.ArrayList;

import twitter4j.*;

/**
 * @author jker3169
 * @version 0.4
 * 
 * this is the twitter interaction class
 * in this class I use what i've learned about api's to
 * 
 */
public class CTECTwitter
{
	private Twitter chatbotTwitter;
	
	private ArrayList<Status> statusList;
	private ArrayList<String> wordList;
	
	public CTECTwitter()
	{
		chatbotTwitter = TwitterFactory.getSingleton();
		
		statusList = new ArrayList<Status>();
		wordList = new ArrayList<String>();
		
	}
	
	public void sendTweet(String tweet)
	{
		try
		{
			chatbotTwitter.updateStatus("I just tweeted from my Java Chatbot program!"
					+ " #APCSRocks @CTECNow Thanks @cscheerleader & @codyhenrichsen!");
		}
		catch (TwitterException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
