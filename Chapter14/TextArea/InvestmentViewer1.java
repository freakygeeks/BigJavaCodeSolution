//Chapter 12 - Example 12.2

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class InvestmentViewer1
{
	private static final double INTEREST_RATE = 10;
	private static final double INITIAL_BALANCE = 1000;
	
	private static final int WIDTH = 400;
	private static final int HEIGHT = 100;
	
	public static void main (String[] args)
	{
		JFrame frame = new JFrame();
		JButton button = new JButton("Add Interest");
		
		final BankAccount account = new BankAccount (INITIAL_BALANCE);
		final JLabel label = new JLabel ("Balance = " + account.getBalance());
		
		JPanel panel = new JPanel();
		panel.add(button);
		panel.add(label);
		frame.add(panel);
		
		class AddInterestListener implements ActionListener
		{
			public void actionPerformed (ActionEvent event)
			{
				double interest = account.getBalance()*INTEREST_RATE/100;
				account.deposit(interest);
				
				label.setText("Balance = " + account.getBalance());
			}
		}		
		
		ActionListener listener = new AddInterestListener();
		button.addActionListener(listener);
		
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
