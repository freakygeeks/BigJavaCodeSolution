//Chapter 12 - Example 12.3

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InvestmentViewer2
{
	private static final double DEFAULT_RATE = 10;
	private static final double INITIAL_BALANCE = 1000;
	
	private static final int WIDTH = 500;
	private static final int HEIGHT = 200;
	
	public static void main (String[] args)
	{
		JFrame frame = new JFrame();
	
		JLabel rateLabel = new JLabel ("Interest Rate : ");
		final int FIELD_WIDTH =10;
		final JTextField rateField = new JTextField(FIELD_WIDTH);
		rateField.setText(" " + DEFAULT_RATE);
	
		JButton button = new JButton("Add Interest");
	
		final BankAccount account = new BankAccount(INITIAL_BALANCE);
		final JLabel resultLabel = new JLabel ("Balance = " + account.getBalance());
	
		JPanel panel = new JPanel();
		panel.add(rateLabel);
		panel.add(rateField);
		panel.add(button);
		panel.add(resultLabel);
		frame.add(panel);
	
		class AddInterestListener implements ActionListener
		{
			public void actionPerformed (ActionEvent event)
			{
				double rate = Double.parseDouble(rateField.getText());
				double interest = account.getBalance()*rate/100;
				account.deposit(interest);
				
				resultLabel.setText("Balance = " + account.getBalance());
			}
		}	
		
		ActionListener listener = new AddInterestListener();
		button.addActionListener(listener);
		
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}