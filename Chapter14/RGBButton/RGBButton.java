//Chapter 14 - Exercise 14.1

import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RGBButton extends JFrame
{
	private JPanel colorPanel;
	private static final int WIDTH = 300;
	private static final int HEIGHT = 300;
	
	//constructs a frame
	public RGBButton()
	{
		colorPanel = new JPanel();
		
		add(colorPanel, BorderLayout.CENTER);
		createControlPanel();
		setSize(WIDTH, HEIGHT);
		
		/*colorPanel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		getContentPane().add(colorPanel, BorderLayout.CENTER);
		createControlPanel();
		pack();*/
	}
	
	//create control panel with button at bottom of frame
	private void createControlPanel()
	{
		JPanel southPanel = new JPanel();
		southPanel.add(makeButton("Red", Color.red));
		southPanel.add(makeButton("Green", Color.green));
		southPanel.add(makeButton("Blue", Color.blue));
		
		add(southPanel, BorderLayout.SOUTH);
		//getContentPane().add(southPanel, BorderLayout.SOUTH);
	}
	
	//make button to change color
	public JButton makeButton(String label, final Color color)
	{
		JButton button = new JButton(label);
		
		class ButtonListener implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
				colorPanel.setBackground(color);
			}
		}
		
		ButtonListener listener = new ButtonListener();
		button.addActionListener(listener);
		return button;
	}
}





























