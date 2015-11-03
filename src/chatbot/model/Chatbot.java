package chatbot.model;

import java.util.ArrayList;
import chatbot.model.Chatbot;
import chatbot.view.ChatbotView;

/**
 * Base version of the 2015 Chatbot class. Only stub methods are provided.
 * Students will complete methods as part of the project.
 * 
 * @author Jared Kerr
 * @version 1.0 10/14/15
 */
public class Chatbot
{
	
	private ArrayList<String> memesList;
	private ArrayList<String> politicalTopicList;
	private String userName;
	private String content;
	
	/**
	 * Creates an instance of the Chatbot with the supplied username.
	 * 
	 * @param userName
	 *            The username for the chatbot.
	 */
	public Chatbot(String userName)
	{
		
		this.memesList = new ArrayList<String>();
		this.politicalTopicList = new ArrayList<String>();
		this.userName = userName;
		this.content = "Swoogetty";
		
		buildMemesList();
		buildPoliticalTopicsList();
		
	}
	
	private void buildMemesList()
	{
		
		this.memesList.add("doge");
		this.memesList.add("aliens");
		this.memesList.add("bad luck brian");
		this.memesList.add("spoderman");
		this.memesList.add("cute animals");
		this.memesList.add("me gusta");
		this.memesList.add("troll");
		this.memesList.add("rare pepe");
		this.memesList.add("what if I told you");
		this.memesList.add("unhelpful highschool teacher");
		this.memesList.add("john cena");
		
	}
	
	private void buildPoliticalTopicsList()
	{
		
		this.politicalTopicList.add("");
		
	}
	
	/**
	 * Checks the length of the supplied string. Returns false if the supplied
	 * String is empty or null, otherwise returns true.
	 * 
	 * @param currentInput
	 * @return A true or false based on the length of the supplied String.
	 */
	public boolean lengthChecker(String currentInput)
	{
		
		boolean hasLength = false;
		if (currentInput != null && currentInput.length() > 0)
		{
			
			hasLength = true;
			
		}
		
		return hasLength;
	}
	
	/**
	 * Checks if the supplied String matches the content area for this Chatbot
	 * instance.
	 * 
	 * @param currentInput
	 *            The supplied String to be checked.
	 * @return Whether it matches the content area.
	 */
	public boolean contentChecker(String currentInput)
	{
		
		boolean hasContent = false;
		
		if (currentInput.toLowerCase().contains(content.toLowerCase()))
		{
			hasContent = true;
		}
		
		return hasContent;
	}
	
	/**
	 * Checks if supplied String matches ANY of the topics in the
	 * politicalTopicsList. Returns true if it does find a match and false if it
	 * does not match.
	 * 
	 * @param currentInput
	 *            The supplied String to be checked.
	 * @return Whether the String is contained in the ArrayList.
	 */
	public boolean politicalTopicChecker(String currentInput)
	{
		return false;
	}
	
	/**
	 * Checks to see that the supplied String value is in the current memesList
	 * variable.
	 * 
	 * @param currentInput
	 *            The supplied String to be checked.
	 * @return Whether the supplied String is a recognized meme.
	 */
	public boolean memeChecker(String currentInput)
	{
		boolean hasMeme = false;
		
		for (String currentMeme : memesList)
		{
			if (currentInput.toLowerCase().contains(currentMeme))
			{
				hasMeme = true;
			}
		}
		
		return hasMeme;
	}
	
	/**
	 * Processes Conversation by comparing to our lists and choosing what to say
	 * back.
	 */
	public String processConversation(String currentChat)
	{
		String returnChat = "";
		int randomTopic = (int) (Math.random() * 5); //Generates a random number between 0 and 4.
		
		switch (randomTopic)
		{
			case 0:
				if(memeChecker(currentChat))
				{
					returnChat = "That is a very popular meme this year. What else are you"
							+ " wanting to talk about?"; 
				}
				break;
			case 1:
				if(politicalTopicChecker(currentChat))
				{
					returnChat = "Wow up to date are we. Well what other things are you"
							+ " intrested in?";
				}
				break;
			case 2:
				if(memeChecker(currentChat))
				{
					returnChat = "100";
				}
				break;
			case 3:
				if(politicalTopicChecker(currentChat))
				{
					returnChat = "5649";
				}
				break;
			case 4:
				returnChat = "UR FUNNY MATE";
				break;
			default:
				returnChat = "The Unvers has collapsed and so that suck lol";
				break;
		}
		return returnChat;
	}
	
	/**
	 * Returns the username of this Chatbot instance.
	 * 
	 * @return The username of the Chatbot.
	 */
	public String getUserName()
	{
		return userName;
	}
	
	/**
	 * Returns the content area for this Chatbot instance.
	 * 
	 * @return The content area for this Chatbot instance.
	 */
	public String getContent()
	{
		return content;
	}
	
	/**
	 * Getter method for the memesList object.
	 * 
	 * @return The reference to the meme list.
	 */
	public ArrayList<String> getMemesList()
	{
		return memesList;
	}
	
	/**
	 * Getter method for the politicalTopicList object.
	 * 
	 * @return The reference to the political topic list.
	 */
	public ArrayList<String> getPoliticalTopicList()
	{
		return politicalTopicList;
	}
	
	/**
	 * Updates the content area for this Chatbot instance.
	 * 
	 * @param content
	 *            The updated value for the content area.
	 */
	public void setContent(String content)
	{
		this.content = content;
	}
}
