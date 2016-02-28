//Chapter 14 - Exercise 14.5

import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RGBCheckBox extends JFrame
{
	private JPanel colorPanel;
	private JCheckBox redButton;
	private JCheckBox greenButton;
	private JCheckBox blueButton;
	private static final int WIDTH = 300;
	private static final int HEIGHT = 300;
	
	public RGBCheckBox()
	{
		colorPanel = new JPanel();
		colorPanel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		getContentPane().add(colorPanel, BorderLayout.CENTER);
		createControlPanel();
		pack();
	}
	
	//create control panel to change color
	public void createControlPanel()
	{
		redButton = new JCheckBox("Red");
		greenButton = new JCheckBox("Green");
		blueButton = new JCheckBox("Blue");
		
		class CheckBoxListener implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
				setColor();
			}
		}
		
		redButton.addActionListener(new CheckBoxListener());
		greenButton.addActionListener(new CheckBoxListener());
		blueButton.addActionListener(new CheckBoxListener());
		
		JPanel southPanel = new JPanel();
		southPanel.add(redButton);
		southPanel.add(greenButton);
		southPanel.add(blueButton);
		
		getContentPane().add(southPanel, BorderLayout.SOUTH);
		setColor();
	}
	
	//create color to be selected
	public void setColor()
	{
		float red = 0;
		float green = 0;
		float blue = 0;
		
		if (redButton.isSelected())
			{
				red = 1;
			}
		if (greenButton.isSelected())
			{
				green = 1;
			}
		if (blueButton.isSelected())
			{
				blue = 1;
			}
			
		Color aColor = new Color(red, green, blue);
		colorPanel.setBackground(aColor);
	}	
}






























