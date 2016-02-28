

import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Graphics;

public class RectangleButtonFrame extends JFrame
{
	private RectangleButtonPanel rectPanel;
	private static final int WIDTH = 600;
	private static final int HEIGHT = 600;
	
	public RectangleButtonFrame()
	{
		rectPanel = new RectangleButtonPanel();
		
		rectPanel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		getContentPane().add(rectPanel, BorderLayout.CENTER);
		createControlPanel();
		pack();
	}
	
	/*public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		rectPanel.paint(g);
	}*/
	
	
	private void createControlPanel()
	{	
		JPanel southPanel = new JPanel();
		southPanel.add(makeButton("Fewer"));
		southPanel.add(makeButton("More"));
		
		add(southPanel, BorderLayout.SOUTH);
	}
	
	public JButton makeButton(String label)
	{	
		/*JButton fewerButton = new JButton("Fewer");
		JButton moreButton = new JButton("More");*/
		
		JButton button = new JButton(label);	
		
		class ButtonListener implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
						rectPanel.setNumber(50);
						rectPanel.randomLocation();
						//repaint();
			}
		}
		
		ButtonListener listener = new ButtonListener();
		button.addActionListener(listener);
		return button;
		
		/*JPanel controlPanel = new JPanel();
		controlPanel.add(fewerButton);
		
		getContentPane().add(controlPanel, BorderLayout.SOUTH);*/
		
	}
}















