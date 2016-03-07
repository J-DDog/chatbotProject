package chatbot.model;

import java.util.ArrayList;

import twitter4j.*;

/**
 * @author jker3169
 * @version 0.3
 * 
 * this is the twitter interaction class
 * in this class I use what i've learned about api's to
 * 
 */
public class CTECTwitter
{
	private ArrayList<Status> statusList;
	private ArrayList<String> wordList;
	private Twitter chatbotTwitter;
	
	public CTECTwitter()
	{
		statusList = new ArrayList<Status>();
		wordList = new ArrayList<String>();
		
	}
	
	public void sendTweet()
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
