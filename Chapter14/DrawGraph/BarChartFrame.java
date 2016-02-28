//Chapter 14 - Exercise 14.12

import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComboBox;

public class BarChartFrame extends JFrame
{
	private BarChartPanel graphPanel;
	
	public BarChartFrame()
	{
		graphPanel = new BarChartPanel();
		getContentPane().add(graphPanel, BorderLayout.CENTER);
		
		createControlPanel();
		pack();
	}
	
	public void createControlPanel()
	{
		JButton addButton = new JButton("Draw Graph");
		
		final JTextField nameField = new JTextField();
		final JTextField lengthField = new JTextField("10");
		final JComboBox colorCombo = new JComboBox();
		colorCombo.addItem("Red");
		colorCombo.addItem("Green");
		colorCombo.addItem("Blue");
		
		class ButtonListener implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
				String name = nameField.getText();
				int length = Integer.parseInt(lengthField.getText());
				Color c = Color.black;
				String color = (String)colorCombo.getSelectedItem();
				
				if (color.equals("Red"))
				{
					c = Color.red;
				}
				else if (color.equals("Green"))
				{
					c = Color.green;
				}
				else if (color.equals("Blue"))
				{
					c = Color.blue;
				}
				
				BarChart b = new BarChart (name, length, c);
				graphPanel.addBar(b);
			}
		}
		
		ActionListener listener = new ButtonListener();
		addButton.addActionListener(listener);
		
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new GridLayout(3,2));
		northPanel.add(new JLabel("Title"));
		northPanel.add(nameField);
		northPanel.add(new JLabel("Number"));
		northPanel.add(lengthField);
		northPanel.add(new JLabel("Color"));
		northPanel.add(colorCombo);
		
		JPanel southPanel = new JPanel();
		southPanel.add(addButton);
		
		getContentPane().add(northPanel, BorderLayout.NORTH);
		getContentPane().add(southPanel, BorderLayout.SOUTH);		
	}
}













































