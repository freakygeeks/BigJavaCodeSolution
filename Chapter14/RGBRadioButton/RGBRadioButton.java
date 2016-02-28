//Chapter 14 - Exercise 14.4

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

public class RGBRadioButton extends JFrame
{
	private JPanel colorPanel;
	private Color aColor;
	private ActionListener listener;
	private JRadioButton redButton;
	private JRadioButton greenButton;
	private JRadioButton blueButton;
	private static final int WIDTH = 300;
	private static final int HEIGHT = 300;
	
	//construct a frame
	public RGBRadioButton()
	{
		colorPanel = new JPanel();
		
		add(colorPanel, BorderLayout.CENTER);
		
		createControlPanel();
		setSize(WIDTH, HEIGHT);
	}
	
	public void createControlPanel()
	{
		JPanel radioButton = createRadioButton();
		
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new GridLayout(1,1));
		southPanel.add(radioButton);
		
		add(southPanel, BorderLayout.SOUTH);
	}
	
	public JPanel createRadioButton()
	{
		redButton = new JRadioButton("Red");
		redButton.addActionListener(listener);
		//redButton.setSelected(true);
		
		greenButton = new JRadioButton("Green");
		greenButton.addActionListener(listener);
		//greenButton.setSelected(true);
		
		blueButton = new JRadioButton("Blue");
		blueButton.addActionListener(listener);
		//blueButton.setSelected(true);
		
		ButtonGroup group = new ButtonGroup();
		group.add(redButton);
		group.add(greenButton);
		group.add(blueButton);
		
		JPanel panel = new JPanel();
		panel.add(redButton);
		panel.add(greenButton);
		panel.add(blueButton);
		
		class RadioListener implements ActionListener
		{
			public void actionPerformed (ActionEvent event)
			{
				if (redButton.isSelected())
				{
					aColor = Color.red;
				}
				else if (greenButton.isSelected())
				{
					aColor = Color.green;
				}
				else if (blueButton.isSelected())
				{
					aColor = Color.blue;
				}
			
				colorPanel.setBackground(aColor);
			}
		}		
		
		RadioListener listener = new RadioListener();
		redButton.addActionListener(listener);
		greenButton.addActionListener(listener);
		blueButton.addActionListener(listener);
		
		return panel;
	}
}






























