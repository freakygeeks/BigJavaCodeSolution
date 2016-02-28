//Chapter 24 - Exercise 24.9

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.awt.*;
import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.KeyEvent;

public class ChatClient extends JFrame
{
	private BorderLayout borderLayout = new BorderLayout();
	private JPanel panel = new JPanel();
	private JLabel title = new JLabel();
	private JScrollPane scrollPaneA = new JScrollPane();
	private JTextArea msgBoard = new JTextArea();
	private JScrollPane scrollPaneB = new JScrollPane();
	private JTextArea commandLine = new JTextArea();
	private PrintWriter writer = null;
	private String host;
	private int port;
	private Socket s = null;
	
	public ChatClient (String aHost, int aPort) throws IOException
	{
		host = aHost;
		port = aPort;
		
		try
		{
			this.getContentPane().setLayout(borderLayout);
			setSize(400, 400);
			setTitle("Chat Client");
			title.setText("Chat Room");
			msgBoard.setText("Welcome to chat room!\n\n");
			msgBoard.append("Please enter your command within the text field at bottom\n");
			msgBoard.append("Usage : LOGIN username\n");
			msgBoard.append("            CHAT message\n");
			msgBoard.append("            LOGOUT\n");
			msgBoard.append("Press ENTER to send your message.\n");
			commandLine.setText("");
			msgBoard.setEditable(false);
			
			this.getContentPane().add(panel, BorderLayout.NORTH);
			panel.add(title, null);
			this.getContentPane().add(scrollPaneA, BorderLayout.CENTER);
			this.getContentPane().add(scrollPaneB, BorderLayout.SOUTH);
			scrollPaneA.getViewport().add(msgBoard, null);
			scrollPaneB.getViewport().add(commandLine, null);
			
			this.addWindowListener (new WindowAdapter()
			{
				public void windowClosing (WindowEvent we)
				{
					System.exit(0);
				}
			}
			);
			
			commandLine.addKeyListener(new java.awt.event.KeyAdapter()
			{
				public void keyReleased (KeyEvent ke)
				{
					try
					{
						commandLine_keyReleased(ke);
					}
					catch (IOException e)
					{
					}
				}
			}
			);
			
			centerFrame(this);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	//the chatter enters the chat room. makes the socket connection to chat server
	public void enterChatRoom() throws IOException
	{
		s = new Socket(host, port);
		InputStream in = s.getInputStream();
		OutputStream out = s.getOutputStream();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		writer = new PrintWriter(out);
		
		String name;
		String response = null;
		
		while (true)
		{
			response = reader.readLine();
			msgBoard.append(response + "\n");
			
			if (response.equals("Good-bye!"))
			{
				break;
			}
		}
		s.close();
	}
	
	//this centers frame in the middle of the screen
	public void centerFrame (JFrame aFrame)
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = aFrame.getSize();
		
		if (frameSize.height > screenSize.height)
		{
			frameSize.height = screenSize.height;
		}
		
		if (frameSize.width > screenSize.width)
		{
			frameSize.width = screenSize.width;
		}
		
		aFrame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height)/2); 
		aFrame.setVisible(true);
	}
	
	//send command to chat server when user hits ENTER
	public void commandLine_keyReleased(KeyEvent e) throws IOException
	{
		if (e.getKeyCode() == e.VK_ENTER)
		{
			String command = commandLine.getText();
			writer.print(command + "\n");
			writer.flush();
			commandLine.setText("");
		}
	}
	
	public static void main (String[] args) throws IOException
	{
		final int PORT = 8888;
		final String HOST = "localhost";
		new ChatClient(HOST, PORT).enterChatRoom();
	}
}




















