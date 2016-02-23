package chatbot.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import chatbot.controller.ChatbotController;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
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
		typingField.setToolTipText("Type Here"); 
		enterButton = new JButton("Enter");
		baseLayout.putConstraint(SpringLayout.WEST, enterButton, 20, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, enterButton, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, typingField, 6, SpringLayout.EAST, enterButton);
		
		
		setupChatPane();		
		setupPanel();
		setupLayout();
		setupListeners();
		changeRandomColor();
		
	}
	
	private void setupChatPane()
	{
		chatArea = new JTextArea();
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
		chatArea.setEditable(false);
		chatArea.append("  Chatbot: Hello " + userName);
		scrollPane = new JScrollPane(chatArea);
		baseLayout.putConstraint(SpringLayout.NORTH, typingField, 10, SpringLayout.SOUTH, scrollPane);
		baseLayout.putConstraint(SpringLayout.EAST, typingField, 0, SpringLayout.EAST, scrollPane);
		baseLayout.putConstraint(SpringLayout.WEST, scrollPane, 150, SpringLayout.WEST, this);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	}

	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.add(typingField);
		this.add(enterButton);
		this.add(scrollPane);
		
		JPanel buttonPanel = new JPanel();
		baseLayout.putConstraint(SpringLayout.SOUTH, buttonPanel, -10, SpringLayout.NORTH, typingField);
		baseLayout.putConstraint(SpringLayout.NORTH, buttonPanel, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, buttonPanel, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, buttonPanel, -6, SpringLayout.WEST, scrollPane);
		add(buttonPanel);
		buttonPanel.setLayout(new SpringLayout());
		quitButton = new JButton("Quit");
		baseLayout.putConstraint(SpringLayout.SOUTH, quitButton, -21, SpringLayout.SOUTH, buttonPanel);
		baseLayout.putConstraint(SpringLayout.EAST, quitButton, -10, SpringLayout.EAST, buttonPanel);
		buttonPanel.add(quitButton);
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, chatArea, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatArea, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, chatArea, -30, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatArea, -50, SpringLayout.SOUTH, this);
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
				enterPressed();

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
		
		typingField.addKeyListener(new KeyListener()
		{

			@Override
			public void keyTyped(KeyEvent key)
			{
				
				
			}

			@Override
			public void keyPressed(KeyEvent key)
			{
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent key)
			{
				int keyCode = key.getKeyCode();
				int KeyCompare = KeyEvent.VK_ENTER;
				if(keyCode == KeyCompare)
				{
					enterPressed();
				}
				
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

	private void enterPressed()
	{
		String userText = typingField.getText(); //Grab user typed answer
		if(userText.equals("") == false)
		{
			chatArea.append("\n"+ userName + ": " + userText); //display typed answer
			typingField.setText(""); 
			String responce = baseController.userToChatbot(userText); //send the text to chatbot
			//chatbot will process
			chatArea.append("\n  Chatbot: " + responce); //display the response
		}
	}
	
	public JComponent getTextField()
	{
		return typingField;
	}
}
