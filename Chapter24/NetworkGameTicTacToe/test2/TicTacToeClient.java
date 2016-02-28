//Chapter 24 - Project 24.1

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TicTacToeClient
{
	private JFrame frame = new JFrame("Tic Tac Toe");
	private JLabel msgLabel = new JLabel("");
	private ImageIcon icon;
	private ImageIcon opponentIcon;
	private Square[] board = new Square[9];
	private Square currentSquare;
	private static int PORT = 8888;
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	
	public TicTacToeClient (String serverAddress) throws Exception
	{
		socket = new Socket(serverAddress, PORT);
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(socket.getOutputStream(), true);
		
		msgLabel.setBackground(Color.lightGray);
		frame.getContentPane().add(msgLabel, "South");
		
		JPanel boardPanel = new JPanel();
		boardPanel.setBackground(Color.black);
		boardPanel.setLayout(new GridLayout(3,3,2,2));
		
		for (int i = 0; i < board.length; i++)
		{
			final int j = i;
			board[i] = new Square();
			board[i].addMouseListener(new MouseAdapter()
			{
				public void mousePressed(MouseEvent e)
				{
					currentSquare = board[j];
					out.println("MOVE " + j);
				}
			}
			);
			boardPanel.add(board[i]);
		}
		frame.getContentPane().add(boardPanel, "Center");
	}
	
	public void play() throws Exception
	{
		String response;
		
		try
		{
			response = in.readLine();
			if (response.startsWith("WELCOME"))
			{
				char mark = response.charAt(8);
				icon = new ImageIcon(mark == 'X' ? "x.png" : "o.png");
				opponentIcon = new ImageIcon(mark == 'X' ? "o.png" : "x.png");
				frame.setTitle("Tic Tac Toe - Player " + mark);
			}
			
			while (true)
			{
				response = in.readLine();
				
				if (response.startsWith("VALID_MOVE"))
				{
					msgLabel.setText("Valid move, please wait");
					currentSquare.setIcon(icon);
					currentSquare.repaint();
				}
				else if (response.startsWith("OPPONENT_MOVED"))
				{
					int loc = Integer.parseInt(response.substring(15));
					board[loc].setIcon(opponentIcon);
					board[loc].repaint();
					msgLabel.setText("Opponent moved, your turn");
				}
				else if (response.startsWith("VICTORY"))
				{
					msgLabel.setText("You win!");
					break;
				}
				else if (response.startsWith("DEFEAT"))
				{
					msgLabel.setText("You lose!");
					break;
				}
				else if (response.startsWith("TIE"))
				{
					msgLabel.setText("You tied");
					break;
				}
				else if (response.startsWith("MESSAGE"))
				{
					msgLabel.setText(response.substring(8));
				}
			}
			
			out.println("QUIT");
		}
		finally
		{
			socket.close();
		}
	}
	
	private boolean wantsToPlayAgain()
	{
		int response = JOptionPane.showConfirmDialog(frame, "Want to play agaain?", "Tic Tac Toe is Fun Fun Fun", JOptionPane.YES_NO_OPTION);
		frame.dispose();
		return response == JOptionPane.YES_OPTION;
	}
	
	static class Square extends JPanel
	{
		JLabel label =  new JLabel((Icon)null);
		
		public Square()
		{
			setBackground(Color.white);
			add(label);
		}
		
		public void setIcon(Icon icon)
		{
			label.setIcon(icon);
		}
	}
	
	public static void main (String[] args) throws Exception
	{
		while (true)
		{
			String serverAddress = (args.length == 0) ? "localhost" : args[1];
			TicTacToeClient client = new TicTacToeClient(serverAddress);
			client.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			client.frame.setSize(240, 160);
			client.frame.setVisible(true);
			client.frame.setResizable(false);
			client.play();
			
			if (!client.wantsToPlayAgain())
			{
				break;
			}
		}
	}
}






















