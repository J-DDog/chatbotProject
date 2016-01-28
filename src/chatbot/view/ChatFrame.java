package chatbot.view;

import javax.swing.JFrame;
import chatbot.controller.ChatbotController;
import chatbot.view.ChatPanel;

public class ChatFrame extends JFrame
{
	private ChatbotController baseController;
	private ChatPanel basePanel;
	
	private ChatFrame(){}
	
	public ChatFrame(ChatbotController baseController)
	{
		this.baseController = baseController;
		basePanel = new ChatPanel(baseController);
		
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setSize(600, 530);
		this.setTitle("ChatBot");
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public ChatbotController getBaseController()
	{
		return baseController;
	}
	
}
