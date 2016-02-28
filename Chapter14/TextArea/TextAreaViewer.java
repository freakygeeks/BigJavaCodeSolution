//Chapter 14 - Example 14.5

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TextAreaViewer
{
	private static final double RATE = 10;
	private static final double BALANCE = 1000;
	
	private static final int WIDTH = 400;
	private static final int HEIGHT = 400;
	
	public static void main (String[] args)
	{
		JFrame frame = new JFrame();
		frame.setTitle("TextArea for Bank Account");
		frame.setSize(WIDTH, HEIGHT);
		
		//add interest to bank account
		final BankAccount account = new BankAccount(BALANCE);
		
		//text area for displaying result
		final int ROW = 10;
		final int COL = 30;
		final JTextArea textArea = new JTextArea(ROW, COL);
		
		textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textArea);
		
		//label and text field for entering interest rate
		JLabel rateLabel = new JLabel ("Interest Rate : ");
		
		final int WIDTH = 10;
		final JTextField rateField = new JTextField(WIDTH);
		rateField.setText(" " + RATE);
		
		//button to trigger calculation
		JButton calculateButton = new JButton("Add Interest : ");
		
		//panel holds input components
		JPanel northPanel = new JPanel();
		northPanel.add(rateLabel);
		northPanel.add(rateField);
		northPanel.add(calculateButton);
		
		frame.add(northPanel, BorderLayout.NORTH);
		frame.add(scrollPane);
		
		class CalculateListener implements ActionListener
		{
			public void actionPerformed (ActionEvent event)
			{
				double rate = Double.parseDouble(rateField.getText());
				double interest = account.getBalance()*rate/100;
				
				account.deposit(interest);
				textArea.append(account.getBalance() + "\n");
			}
		}

		ActionListener listener = new CalculateListener();
		calculateButton.addActionListener(listener);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
























