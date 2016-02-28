//Chapter 14 - Exercise 14.3

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JFrame
{
	private JTextField display;
	private double lastValue;
	private String lastOperator;
	private boolean start;
	
	//construct the frame
	public Calculator()
	{
		JPanel calPanel = new JPanel();
		calPanel.setLayout(new GridLayout(4,4));
		createControlPanel();
		pack();
	}
	
	//create control panel with text field
	private void createControlPanel()
	{
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(4,4));
		buttonPanel.add(makeDigitButton("7"));
		buttonPanel.add(makeDigitButton("8"));
		buttonPanel.add(makeDigitButton("9"));
		buttonPanel.add(makeOperatorButton("/"));
		buttonPanel.add(makeDigitButton("4"));
		buttonPanel.add(makeDigitButton("5"));
		buttonPanel.add(makeDigitButton("6"));
		buttonPanel.add(makeOperatorButton("*"));
		buttonPanel.add(makeDigitButton("1"));
		buttonPanel.add(makeDigitButton("2"));
		buttonPanel.add(makeDigitButton("3"));
		buttonPanel.add(makeOperatorButton("-"));
		buttonPanel.add(makeDigitButton("0"));
		buttonPanel.add(makeOperatorButton("."));
		buttonPanel.add(makeOperatorButton("="));
		buttonPanel.add(makeOperatorButton("+"));
		
		display = new JTextField("0");
		display.setEditable(false);
		
		getContentPane().add(display, BorderLayout.NORTH);
		getContentPane().add(buttonPanel, BorderLayout.CENTER);
		
		lastValue = 0;
		lastOperator = "=";
		start = true;
	}
	
	//button representing a digit of calculator
	public JButton makeDigitButton (final String digit)
	{
		JButton button = new JButton(digit);
		
		class ButtonListener implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
				if (start)
					{
						display.setText(digit);
					}
				else
					{
						display.setText(display.getText() + digit);
					}
					
				start = false;
			}
		}
		
		ButtonListener listener = new ButtonListener();
		button.addActionListener(listener);
		return button;
	}
	
	//button representing an operator of calculator
	public JButton makeOperatorButton(final String op)
	{
		JButton button = new JButton(op);
		
		class ButtonListener implements ActionListener
		{
			public void actionPerformed (ActionEvent event)
			{
				if (!start)
					{
						double x = Double.parseDouble(display.getText());
						calculate(x);
						start = true;
					}
					
				lastOperator = op;
			}
		}
		
		ButtonListener listener = new ButtonListener();
		button.addActionListener(listener);
		return button;
	}
	
	//calculate the result value
	public void calculate(double n)
	{
		if (lastOperator.equals("+"))
			{
				lastValue = lastValue + n;
			}
		else if (lastOperator.equals("-"))
			{
				lastValue = lastValue - n;
			}
		else if (lastOperator.equals("*"))
			{
				lastValue = lastValue*n;
			}
		else if (lastOperator.equals("/"))
			{
				lastValue = lastValue/n;
			}
		else if (lastOperator.equals("="))
			{
				lastValue = n;
			}
			
		display.setText(" " + lastValue);
	}
}
























































