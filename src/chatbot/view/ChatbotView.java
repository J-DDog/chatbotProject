package chatbot.view;

import javax.swing.JOptionPane;

public class ChatbotView 
{
	
	public ChatbotView()
	{
		
	}
	
	public void displayMessage(String message)
	{
		JOptionPane.showMessageDialog(null, message);
	}
	
	public String getResponce(String message)
	{
		String output = "";
		output = JOptionPane.showInputDialog(null,message);
		return output;
	}
	
}
