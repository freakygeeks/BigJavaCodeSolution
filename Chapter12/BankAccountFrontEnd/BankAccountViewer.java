//Chapter 12 - Exercise 12.8

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BankAccountViewer
{
	private static final double DEFAULT_RATE = 10;
	private static final double INITIAL_BALANCE = 1000;
	
	private static final int WIDTH = 1000;
	private static final int HEIGHT = 100;
	
	public static void main (String[] args)
	{
		final int FIELD_WIDTH = 10;

		JFrame frame = new JFrame();

		//for interest rate text
		JLabel rateLabel = new JLabel ("Interest Rate : ");
		final JTextField rateField = new JTextField(FIELD_WIDTH);
		rateField.setText(" " + DEFAULT_RATE);
	
		//for deposit money text
		JLabel depLabel = new JLabel ("Deposit Money");
		final JTextField depField = new JTextField(FIELD_WIDTH);
		depField.setText(" ");
		
		//for withdraw money test
		JLabel drawLabel = new JLabel ("Withdraw Money");
		final JTextField drawField = new JTextField (FIELD_WIDTH);
		drawField.setText(" ");
		
		//for add interest button
		JButton button = new JButton("Add Interest");
		
		//for deposit money
		JButton buttonDep = new JButton ("Deposit");
		
		//for withdraw money
		JButton buttonDraw = new JButton ("Withdraw");
	
		//for inital balance account
		final BankAccount account = new BankAccount(INITIAL_BALANCE);
		final JLabel resultLabel = new JLabel ("Balance = " + account.getBalance());
	
		JPanel panel = new JPanel();
		panel.add(rateLabel);
		panel.add(rateField);
		panel.add(button);
		panel.add(depLabel);
		panel.add(depField);
		panel.add(buttonDep);
		panel.add(drawLabel);
		panel.add(drawField);
		panel.add(buttonDraw);
		panel.add(resultLabel);
		frame.add(panel);
	
		//listener class for interest
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
		
		//listener class for deposit money
		class AddDepositListener implements ActionListener
		{
			public void actionPerformed (ActionEvent event)
			{
				double dep = Double.parseDouble(depField.getText());
				account.deposit(dep);
			
				resultLabel.setText("Balance = " + account.getBalance());
			}
		}		
		
		//listener class for withdraw money
		class WithdrawListener implements ActionListener
		{
			public void actionPerformed (ActionEvent event)
			{
				double draw = Double.parseDouble (drawField.getText());
				account.withdraw(draw);
			
				resultLabel.setText("Balance = " + account.getBalance());
			}
		}
		
		//callback listener for interet		
		ActionListener listener1 = new AddInterestListener();
		button.addActionListener(listener1);
		
		//callback listener for deposit
		ActionListener listener2 = new AddDepositListener();
		buttonDep.addActionListener(listener2);
		
		//callback listener for withdraw
		ActionListener listener3 = new WithdrawListener();
		buttonDraw.addActionListener(listener3);
		
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}