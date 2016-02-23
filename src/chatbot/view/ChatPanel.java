package chatbot.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import chatbot.controller.ChatbotController;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class ChatPanel extends JPanel
{
	private ChatbotController baseController;
	private SpringLayout baseLayout;
	private JTextField typingField;
	private JTextArea chatArea;
	private JButton enterButton;
	private JButton quitButton;
	private JScrollPane scrollPane;
	private String userName;
	
	public ChatPanel(ChatbotController baseController)
	{
		this.baseController = baseController;
		
		userName = baseController.getUserName();
		
		baseLayout = new SpringLayout();
		typingField = new JTextField();
		typingField.setColumns(10);
		typingField.setToolTipText("type here"); 
		scrollPane = new JScrollPane();
		chatArea = new JTextArea();
		scrollPane.setViewportView(chatArea);
		chatArea.setEditable(false);
		chatArea.append("  Chatbot: Hello " + userName);
		enterButton = new JButton("Enter");
		quitButton = new JButton("Quit");
		
		
		
		setupPanel();
		setupLayout();
		setupListeners();
		
		changeRandomColor();
		
	}
	
	private void setupPanel()
	{
		setLayout(baseLayout);
		add(typingField);
		add(enterButton);
		add(quitButton);
		add(scrollPane);
		
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.SOUTH, enterButton, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, enterButton, -10, SpringLayout.EAST, this);
		
		baseLayout.putConstraint(SpringLayout.WEST, typingField, 10, SpringLayout.EAST, quitButton);
		baseLayout.putConstraint(SpringLayout.NORTH, typingField, 10, SpringLayout.SOUTH, chatArea);
		baseLayout.putConstraint(SpringLayout.EAST, typingField, -10, SpringLayout.WEST, enterButton);
		
		baseLayout.putConstraint(SpringLayout.WEST, quitButton, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, quitButton, 10, SpringLayout.SOUTH, chatArea);

		baseLayout.putConstraint(SpringLayout.NORTH, chatArea, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatArea, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, chatArea, -30, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatArea, -50, SpringLayout.SOUTH, this);
		
		baseLayout.putConstraint(SpringLayout.WEST, scrollPane, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, scrollPane, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -50, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, scrollPane, -10, SpringLayout.EAST, this);
				
	}
	
	private void setupListeners()
	{
		enterButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent acion)
			{
				
				String userText = typingField.getText(); //Grab user typed answer
				chatArea.append("\n"+ userName + ": " + userText); //display typed answer
				typingField.setText(""); 
				String responce = baseController.userToChatbot(userText); //send the text to chatbot
				//chatbot will process
				chatArea.append("\n  Chatbot: " + responce); //display the response
				

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
