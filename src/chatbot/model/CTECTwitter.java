package chatbot.model;

import java.util.ArrayList;
import java.util.List;

import chatbot.controller.ChatbotController;
import twitter4j.*;

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
	
	private ArrayList<Status> statuses;
	private ArrayList<String> wordList;
	
	public CTECTwitter(ChatbotController baseController)
	{		
		this.baseController = baseController;
		chatbotTwitter = TwitterFactory.getSingleton();
		
		statuses = new ArrayList<Status>();
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
	
	public void loadTweets(String twitterHandle) throws TwitterException
	{
		Paging statusPage = new Paging(1, 200);
		int page = 1;
		while(page <= 10)
		{
			statusPage.setPage(page);
			statuses.addAll(chatbotTwitter.getUserTimeline(twitterHandle, statusPage));
			page++;
		}
		for(Status currentStatus: statuses)
		{
			String[] tweetText = currentStatus.getText().split(" ");
			for(String word: tweetText)
			{
				wordList.add(removePunctuation(word).toLowerCase());
			}
		}
		removeCommonEnglishWords(wordList);
		removeEmptyText();
	}

	private void removeEmptyText()
	{
		// TODO Auto-generated method stub
		
	}

	private List removeCommonEnglishWords(ArrayList<String> wordList)
	{
		// TODO Auto-generated method stub
		return null;
	}

	private String removePunctuation(String word)
	{
		// TODO Auto-generated method stub
		return null;
	}
	
}
