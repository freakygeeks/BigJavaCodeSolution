//Chapter 14 - Exercise 14.6

import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComboBox;

public class RGBComboBox extends JFrame
{
	private JPanel colorPanel;
	private JComboBox comboBox;
	private Color aColor;
	private static final int WIDTH = 300;
	private static final int HEIGHT = 300;
	
	public RGBComboBox() 
	{
		colorPanel = new JPanel();
		colorPanel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		getContentPane().add(colorPanel, BorderLayout.CENTER);
		createControlPanel();
		pack();
	}
	
	public void createControlPanel()
	{
		comboBox = new JComboBox();
		comboBox.addItem("Red");
		comboBox.addItem("Green");
		comboBox.addItem("Blue");
		comboBox.setEditable(false);
		
		class ComboBoxListener implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
				setColor();
			}
		}
		comboBox.addActionListener(new ComboBoxListener());

		JPanel southPanel = new JPanel();
		southPanel.add(comboBox);
		
		getContentPane().add(southPanel, BorderLayout.SOUTH);
		setColor();
	}
	
	//create color to be selected
	public void setColor()
	{
		String aString = (String) comboBox.getSelectedItem();
		
		if (aString.equals("Red"))
			{
				aColor = Color.red;
			}
		if (aString.equals("Green"))
			{
				aColor = Color.green;
			}
		if (aString.equals("Blue"))
			{
				aColor = Color.blue;
			}
			
		colorPanel.setBackground(aColor);
	}	
}






































