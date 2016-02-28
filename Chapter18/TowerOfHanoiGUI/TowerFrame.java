//Chapter 18 - Project 18.2

import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TowerFrame extends JFrame
{
	private TowerPanel towerPanel;
	private static final int WIDTH = 400;
	private static final int HEIGHT = 200;
	
	public TowerFrame()
	{
		setSize(WIDTH, HEIGHT);
		towerPanel = new TowerPanel(4);
		
		getContentPane().add(towerPanel, BorderLayout.CENTER);
		createControlPanel();
	}
	
	public void createControlPanel()
	{
		JButton nextButton = new JButton("Next");
		
		class NextButtonListener implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
				towerPanel.drawNextMove();
			}
		}
		
		nextButton.addActionListener(new NextButtonListener());
		
		JPanel southPanel = new JPanel();
		southPanel.add(nextButton);
		getContentPane().add(southPanel, BorderLayout.SOUTH);
	}
}
















