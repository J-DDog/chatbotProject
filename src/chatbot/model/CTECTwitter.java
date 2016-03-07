package chatbot.model;

import java.util.ArrayList;

import twitter4j.*;

/**
 * @author jker3169
 * @version 0.2
 * 
 * this is the twitter interaction class
 * in this class I use what i've learned about api's to
 * 
 */
public class CTECTwitter
{
	private ArrayList<Status> statusList;
	private ArrayList<String> wordList;
	
	public CTECTwitter()
	{
		statusList = new ArrayList<Status>();
		wordList = new ArrayList<String>();
	}
	
}
