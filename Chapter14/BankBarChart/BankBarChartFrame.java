//Chapter 14 - Exercise 14.11

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.geom.Rectangle2D;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BankBarChartFrame extends JFrame
{
	private BankBarChartPanel graphPanel;
	
	public BankBarChartFrame()
	{
		graphPanel = new BankBarChartPanel();
		getContentPane().add(graphPanel, BorderLayout.CENTER);
		createControlPanel();
		pack();
	}
	
	public void createControlPanel()
	{
		JButton calcButton = new JButton ("Calculate");
		final JTextField initialBalance = new JTextField("0");
		final JTextField annualRate = new JTextField("0");
		final JTextField years = new JTextField("30");
		final JTextField balanceField = new JTextField("0");
		
		class ButtonListener implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
				double balance = Double.parseDouble (initialBalance.getText());
				double rate = Double.parseDouble (annualRate.getText());
				int aYears = Integer.parseInt (years.getText());
				
				graphPanel.setCount(aYears + 1);
				graphPanel.addValue(balance);
				
				for (int i = 1; i <= aYears; i++)
				{
					double interest = balance*rate/100;
					balance = balance + interest;
					
					//this is the graph bar display
					graphPanel.addValue(balance);
				}
				
				//this is the balance for calculate
				balanceField.setText("" + balance);
			}
		}
		
			ActionListener listener = new ButtonListener();
			calcButton.addActionListener(listener);
			
			JPanel northPanel = new JPanel();
			northPanel.setLayout(new GridLayout(4,1));
			northPanel.add(new JLabel("Initial Balance"));
			northPanel.add(initialBalance);
			northPanel.add(new JLabel("Annual Rate"));
			northPanel.add(annualRate);
			northPanel.add(new JLabel("Number of Years"));
			northPanel.add(years);
			northPanel.add(calcButton);
			northPanel.add(balanceField);
			
			getContentPane().add(northPanel, BorderLayout.NORTH);
	}
}






























































































