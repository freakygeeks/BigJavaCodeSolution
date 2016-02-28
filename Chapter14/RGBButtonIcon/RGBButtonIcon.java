//Chapter 14 - Exercise 14.2

import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class RGBButtonIcon extends JFrame
{
	private JPanel colorPanel;
	private ImageIcon image;
	private static final int WIDTH = 500;
	private static final int HEIGHT = 500;
	
	//constructs a frame
	public RGBButtonIcon()
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
		southPanel.add(makeButton("Red", image, Color.red));
		southPanel.add(makeButton("Green", image, Color.green));
		southPanel.add(makeButton("Blue", image, Color.blue));
		
		add(southPanel, BorderLayout.SOUTH);
		//getContentPane().add(southPanel, BorderLayout.SOUTH);
	}
	
	//make button to change color
	public JButton makeButton(String label, ImageIcon image, final Color color)
	{
		image = new ImageIcon("freak.png");
		
		JButton button = new JButton(label, image);
		
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






