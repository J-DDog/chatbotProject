package chatbot.view;

import javax.swing.JPanel;
import javax.swing.SpringLayout;

import chatbot.controller.ChatbotController;

public class ChatPanel extends JPanel
{
	private ChatbotController baseController;
	private SpringLayout baseLayout;
	
	public ChatPanel(ChatbotController baseController)
	{
		this.baseController = baseController;
		
		baseLayout = new SpringLayout();
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		
	}
	
	private void setupLayout()
	{
		
	}
	
	private void setupListeners()
	{
		
	}
	
}
