package chatbot.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import chatbot.controller.ChatbotController;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ChatPanel extends JPanel
{
	private ChatbotController baseController;
	private SpringLayout baseLayout;
	private JTextField typingField;
	private JTextArea chatArea;
	private JButton enterButton;
	private boolean firstLine;
	private String userName;
	
	public ChatPanel(ChatbotController baseController)
	{
		this.baseController = baseController;
		
		firstLine = true;
		
		baseLayout = new SpringLayout();
		
		typingField = new JTextField();
		typingField.setColumns(10);
		
		chatArea = new JTextArea();
		
		enterButton = new JButton("Enter");
		
		
		setupPanel();
		setupLayout();
		setupListeners();
		
		userName = baseController.getUserName();
		chatArea.append("Chatbot: Hello " + userName);
	}
	
	private void setupPanel()
	{
		setLayout(baseLayout);
		add(typingField);
		add(enterButton);
		add(chatArea);
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.SOUTH, enterButton, -8, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, typingField, -6, SpringLayout.WEST, enterButton);
		baseLayout.putConstraint(SpringLayout.EAST, enterButton, -10, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, typingField, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, typingField, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, chatArea, -458, SpringLayout.NORTH, typingField);
		baseLayout.putConstraint(SpringLayout.WEST, chatArea, 0, SpringLayout.WEST, typingField);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatArea, -6, SpringLayout.NORTH, typingField);
		baseLayout.putConstraint(SpringLayout.EAST, chatArea, 0, SpringLayout.EAST, enterButton);
		
	}
	
	private void setupListeners()
	{
		enterButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent acion)
			{
				
				//Need to do this
				//Grab user typed answer
				//display typed answer
				//send the text to chatbot
				//chatbot will prosses
				//display the responce
				String userText = typingField.getText();
				chatArea.append("\n"+ userName + ": " + userText);
				typingField.setText("");
				String responce = baseController.userToChatbot(userText);
				chatArea.append("\n  Chatbot: " + responce);
			}
			
		});
	}

	public JComponent getTextField()
	{
		return typingField;
	}
}
