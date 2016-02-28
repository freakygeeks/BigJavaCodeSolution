//Chapter 17 - Example 17.5

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class KeyPad extends JPanel
{
	private JPanel buttonPanel;
	private JButton clearButton;
	private JTextField display;
	
	public KeyPad()
	{
		setLayout(new BorderLayout());
		display = new JTextField();
		add(display, "North");
		
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(4,3));
		
		//add digit button
		addButton("7");
		addButton("8");
		addButton("9");
		addButton("4");
		addButton("5");
		addButton("6");
		addButton("1");
		addButton("2");
		addButton("3");
		addButton("0");
		addButton(".");
		
		//add clear button
		clearButton = new JButton("CE");
		buttonPanel.add(clearButton);
		
		class ClearButtonListener implements ActionListener
		{
			public void actionPerformed (ActionEvent event)
			{
				display.setText("");
			}
		}
		
		ActionListener listener = new ClearButtonListener();
		clearButton.addActionListener(listener);
		add(buttonPanel, "Center");
	}
	
	//add button to panel
	public void addButton (final String label)
	{
		JButton button = new JButton(label);
		buttonPanel.add(button);
		
		class DigitButtonListener implements ActionListener
		{
			public void actionPerformed (ActionEvent event)
			{
				//dont add two decimal points
				if (label.equals(".") && display.getText().indexOf(".") != -1)
				{
					return;
				}
				
				display.setText(display.getText() + label);
			}
		}

		ActionListener listener = new DigitButtonListener();
		button.addActionListener(listener);
	}
	
	//get value user enter
	public double getValue()
	{
		return Double.parseDouble(display.getText());
	}
	
	//clear display
	public void clear()
	{
		display.setText("");
	}
}






























