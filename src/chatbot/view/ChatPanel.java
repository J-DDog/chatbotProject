package chatbot.view;

import java.awt.Color;
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
	private JButton quitButton;
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
		quitButton = new JButton("Quit");
		
		setupPanel();
		setupLayout();
		setupListeners();
		
		changeRandomColor();
		
		userName = baseController.getUserName();
		chatArea.append("  Chatbot: Hello " + userName);
	}
	
	private void setupPanel()
	{
		setLayout(baseLayout);
		add(typingField);
		add(enterButton);
		add(chatArea);
		add(quitButton);
		
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.SOUTH, enterButton, -8, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, enterButton, -10, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, quitButton, 7, SpringLayout.SOUTH, chatArea);
		baseLayout.putConstraint(SpringLayout.WEST, typingField, 6, SpringLayout.EAST, quitButton);
		baseLayout.putConstraint(SpringLayout.WEST, quitButton, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, typingField, -6, SpringLayout.WEST, enterButton);
		baseLayout.putConstraint(SpringLayout.NORTH, typingField, 6, SpringLayout.SOUTH, chatArea);
		baseLayout.putConstraint(SpringLayout.NORTH, chatArea, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatArea, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatArea, -44, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, chatArea, -10, SpringLayout.EAST, this);
		
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
		quitButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent action)
			{
				baseController.shutDown();
			}
		});
	}
	
	private void changeRandomColor()
	{
		int red, blue, green;
		red = (int) (Math.random() * 256);
		blue = (int) (Math.random() * 256);
		green = (int) (Math.random() * 256);
		
		this.setBackground(new Color(red, green, blue));
	}

	public JComponent getTextField()
	{
		return typingField;
	}
}
