//Chapter 17 - Exercise 17.8

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EmailSystemFrame extends JFrame
{
	private static final int WIDTH = 300;
	private static final int HEIGHT = 300;
	private CardLayout cardLayout;
	private JPanel mainPanel;
	private JPanel loginPanel;
	private JPanel accountPanel;
	private JPanel readReceivedEmailPanel;
	private JPanel readSentEmailPanel;
	private JPanel composeEmailPanel;
	private EmailSystem emailSystem;
	
	public EmailSystemFrame (UserDatabase userDB)
	{
		emailSystem = new EmailSystem(userDB);
		createComponents(); 
		showState();
		super.setTitle("Login");
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setSize(WIDTH, HEIGHT);
		super.setVisible(true);
	}
	
	private void createComponents()
	{
		loginPanel = createLoginPanel();
		accountPanel = createAccountPanel();
		composeEmailPanel = createComposeEmailPanel();
		readReceivedEmailPanel = createReadReceivedEmailPanel();
		readSentEmailPanel = createReadSentEmailPanel();
		mainPanel = createMainPanel();
		super.add(mainPanel);
	}
	
	private JPanel createMainPanel()
	{
		cardLayout = new CardLayout();
		JPanel panel = new JPanel(cardLayout);
		panel.add(loginPanel, "loginPanel");
		panel.add(accountPanel, "accountPanel");
		panel.add(readReceivedEmailPanel, "readReceivedEmailPanel");
		panel.add(readSentEmailPanel, "readSentEmailPanel");
		panel.add(composeEmailPanel, "composeEmailPanel");
		return panel;
	}
	
	private JPanel createLoginPanel()
	{
		final int FIELD = 10;
		JLabel usernameLabel = new JLabel("Username : ");
		JLabel passwordLabel = new JLabel("Password : ");
		final JTextField usernameField = new JTextField(FIELD);
		final JTextField passwordField = new JTextField(FIELD);
		
		JButton loginButton = new JButton("Login");
		loginPanel = new JPanel(new BorderLayout());
		
		loginButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String username = usernameField.getText();
				String password = passwordField.getText();
				
				if (EmailSystemFrame.this.emailSystem.canLoginUser(username, password))
				{
					EmailSystemFrame.this.emailSystem.setState(EmailSystem.ACCOUNT);
				}
				EmailSystemFrame.this.showState();
			}
		});
		
		JPanel rootPanel = new JPanel(new BorderLayout());
		JPanel usernamePanel = new JPanel();
		usernamePanel.add(usernameLabel);
		usernamePanel.add(usernameField);
		JPanel passwordPanel = new JPanel();
		passwordPanel.add(passwordLabel);
		passwordPanel.add(passwordField);
		rootPanel.add(usernamePanel, BorderLayout.NORTH);
		rootPanel.add(passwordPanel, BorderLayout.CENTER);
		rootPanel.add(loginButton, BorderLayout.SOUTH);
		return rootPanel;
	}
	
	private JPanel createAccountPanel()
	{
		JPanel panel = new JPanel(new GridLayout(3,1));
		
		JButton composeEmailButton = new JButton("Compose");
		composeEmailButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				EmailSystemFrame.this.emailSystem.setState(EmailSystem.WRITE_EMAIL);
				EmailSystemFrame.this.showState();
			}
		});
		
		JButton logoutButton = new JButton("Logout");
		logoutButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				EmailSystemFrame.this.emailSystem.setState(EmailSystem.START);
				EmailSystemFrame.this.showState();
			}
		});
		
		JButton readReceivedEmailButton = new JButton("Read received email");
		readReceivedEmailButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				EmailSystemFrame.this.emailSystem.setState(EmailSystem.READ_RECEIVED);
				EmailSystemFrame.this.showState();
			}
		});
		
		JButton readSentEmailButton = new JButton("Read sent email");
		readSentEmailButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				EmailSystemFrame.this.emailSystem.setState(EmailSystem.READ_SENT);
				EmailSystemFrame.this.showState();
			}
		});
		
		panel.add(composeEmailButton);
		panel.add(readReceivedEmailButton);
		panel.add(readSentEmailButton);
		panel.add(logoutButton);
		return panel;
	}
	
	private JPanel createReadReceivedEmailPanel()
	{
		List<Message> emails;
		
		try
		{
			emails = emailSystem.getReceivedEmails();
		}
		catch (Exception e)
		{
			emails = Collections.emptyList();
		}
		
		JPanel panel = new JPanel();
		JLabel senderLabel = new JLabel("Sender : ");
		JLabel titleLabel = new JLabel("Title : ");
		JTextArea messageText = createTextArea();
		
		if (!emails.isEmpty())
		{
			Message mostRecentEmail = emails.get(emails.size()-1);
			senderLabel.setText(senderLabel.getText() + mostRecentEmail.getSender());
			titleLabel.setText(titleLabel.getText() + mostRecentEmail.getTitle());
			messageText.setText(mostRecentEmail.getText());
		}
		
		panel.add(createEmailsTitlesComboBox(emails));
		JButton backButton = createBackButton();
		panel.add(backButton);
		return panel;
	}
	
	private JButton createBackButton()
	{
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				EmailSystemFrame.this.emailSystem.setState(EmailSystem.ACCOUNT);
				EmailSystemFrame.this.showState();
			}
		});
		return backButton;
	}
	
	private JPanel createReadSentEmailPanel()
	{
		List<Message> emails;
		try
		{
			emails = emailSystem.getSentEmails();
		}
		catch (Exception e)
		{
			emails = Collections.emptyList();
		}
		
		JPanel panel = new JPanel();
		JLabel senderLabel = new JLabel("Sender : ");
		JLabel titleLabel = new JLabel("Title : ");
		JTextArea messageText = createTextArea();
		
		if(!emails.isEmpty())
		{
			Message mostRecentEmail = emails.get(emails.size()-1);
			senderLabel.setText(senderLabel.getText() + mostRecentEmail.getSender());
			titleLabel.setText(titleLabel.getText() + mostRecentEmail.getTitle());
			messageText.setText(mostRecentEmail.getText());
		}		
		
		panel.add(createEmailsTitlesComboBox(emails));
		JButton backButton = createBackButton();
		panel.add(backButton);
		return panel;
	}
	
	private JComboBox<Message> createEmailsTitlesComboBox(List<Message> emails)
	{
		JComboBox<Message> comboBox = new JComboBox<Message>();
		
		for (Message email : emails)
		{
			comboBox.addItem(email);
		}
		comboBox.setSelectedIndex(comboBox.getItemCount()-1);
		return comboBox;
	}
	
	private JTextArea createTextArea()
	{
		JTextArea textArea = new JTextArea(10, 20);
		textArea.setEditable(true);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		return textArea;
	}
	
	private JPanel createComposeEmailPanel()
	{
		final int FIELD = 10;
		final JTextField senderField = new JTextField(FIELD);
		final JTextField recipientField = new JTextField(FIELD);
		final JTextField titleField = new JTextField(FIELD);
		final JTextArea messageText = createTextArea();
		
		JButton sendEmailButton = new JButton("Send");
		sendEmailButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				Message email = new Message(recipientField.getText(), senderField.getText(), titleField.getText(), messageText.getText());
				EmailSystemFrame.this.emailSystem.sendEmail(recipientField.getText(), email);
				EmailSystemFrame.this.emailSystem.setState(EmailSystem.ACCOUNT);
				EmailSystemFrame.this.showState();
			}
		});
		
		JPanel rootPanel = new JPanel(new BorderLayout());
		JPanel senderPanel = new JPanel();
		senderPanel.add(new JLabel("Sender : "));
		senderPanel.add(senderField);
		
		JPanel recipientPanel = new JPanel();
		recipientPanel.add(new JLabel("Recipient : "));
		recipientPanel.add(recipientField);
		
		JPanel fieldPanel = new JPanel(new BorderLayout());
		JPanel titlePanel = new JPanel();
		titlePanel.add(new JLabel("Title : "));
		titlePanel.add(titleField);
		
		fieldPanel.add(senderPanel, BorderLayout.NORTH);
		fieldPanel.add(recipientPanel, BorderLayout.CENTER);
		fieldPanel.add(titlePanel, BorderLayout.SOUTH);
		
		JPanel botPanel = new JPanel(new BorderLayout());
		botPanel.add(messageText, BorderLayout.CENTER);
		JPanel botButtonsPanel = new JPanel();
		botButtonsPanel.add(createBackButton());
		botButtonsPanel.add(sendEmailButton);
		botPanel.add(botButtonsPanel, BorderLayout.SOUTH);
		rootPanel.add(botPanel, BorderLayout.CENTER);
		return rootPanel;
	}
	
	private void showState()
	{
		int state = emailSystem.getState();
		
		if (state == EmailSystem.ACCOUNT)
		{
			cardLayout.show(mainPanel, "accountPanel");
		}
		
		else if (state == EmailSystem.READ_RECEIVED)
		{
			cardLayout.show(mainPanel, "readReceivedEmailPanel");
		}
		
		else if (state == EmailSystem.READ_SENT)
		{
			cardLayout.show(mainPanel, "readSentEmailPanel");
		}
		
		else if (state == EmailSystem.START)
		{
			cardLayout.show(mainPanel, "loginPanel");
		}
		
		else if (state == EmailSystem.WRITE_EMAIL)
		{
			cardLayout.show(mainPanel, "composeEmailPanel");
		}
	}
}












































