//Chapter 17 - Example 17.5

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ATMFrame extends JFrame
{
	private JButton aButton;
	private JButton bButton;
	private JButton cButton;
	private KeyPad pad;
	private JTextArea display;
	private ATM theATM;
	private static final int WIDTH = 300;
	private static final int HEIGHT = 400;
	
	//frame display components of ATM
	public ATMFrame(ATM anATM)
	{
		theATM = anATM;
		pad = new KeyPad();
		display = new JTextArea(4, 20);
		
		aButton = new JButton(" A ");
		aButton.addActionListener(new aButtonListener());
		
		bButton = new JButton (" B ");
		bButton.addActionListener(new bButtonListener());
		
		cButton = new JButton(" C ");
		cButton.addActionListener(new cButtonListener());
		
		//add components
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(3, 1));
		buttonPanel.add(aButton);
		buttonPanel.add(bButton);
		buttonPanel.add(cButton);
		
		setLayout(new FlowLayout());
		add(pad);
		add(display);
		add(buttonPanel);
		showState();
		
		setSize(WIDTH, HEIGHT);
	}
	
	//updates display message
	public void showState()
	{
		int state = theATM.getState();
		pad.clear();
		
		if (state == ATM.START)
		{
			display.setText("Enter customer number\nA = OK");
		}
		
		else if (state == ATM.PIN)
		{
			display.setText("Enter PIN\nA = OK");
		}
		
		else if (state == ATM.ACCOUNT)
		{
			display.setText("Select account\n" + "A = Checking\nB = Savings\nC = Exit");
		}
		
		else if (state == ATM.TRANSACT)
		{
			display.setText("Balance = " + theATM.getBalance() + "\nEnter amount and select transaction\n" + "A = Withdraw\nB = Deposit\nC = Cancel");
		}
	}
	
	private class aButtonListener implements ActionListener
	{
		public void actionPerformed (ActionEvent event)
		{
			int state = theATM.getState();
			
			if (state == ATM.START)
			{
				theATM.setCustomerNumber((int)pad.getValue());
			}
			
			else if (state == ATM.PIN)
			{
				theATM.selectCustomer((int)pad.getValue());
			}
			
			else if (state == ATM.ACCOUNT)
			{
				theATM.selectAccount(ATM.CHECKING);
			}
			
			else if (state == ATM.TRANSACT)
			{
				theATM.withdraw(pad.getValue());
				theATM.back();
			}
			
			showState();
		}
	}
	
	private class bButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			int state = theATM.getState();
			
			if (state == ATM.ACCOUNT)
			{
				theATM.selectAccount(ATM.SAVINGS);
			}
			
			else if (state == ATM.TRANSACT)
			{
				theATM.deposit(pad.getValue());
				theATM.back();
			}
			
			showState();
		}
	}
	
	private class cButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			int state = theATM.getState();
			
			if (state == ATM.ACCOUNT)
			{
				theATM.reset();
			}
			
			else if (state == ATM.TRANSACT)
			{
				theATM.back();
			}
			
			showState();
		}
	}
}


























