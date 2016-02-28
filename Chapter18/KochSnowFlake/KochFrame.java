//Chapter 18 - Exercise P18.15

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class KochFrame extends JFrame
{
	private KochComponent component;
	private static final int F_WIDTH = 360;
	private static final int F_HEIGHT = 500;
	private static final int C_WIDTH = 300;
	private static final int C_HEIGHT = 400;
	
	public KochFrame()
	{
		setSize(F_WIDTH, F_HEIGHT);
		setTitle("Koch Viewer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.add(makeNextButton());
		
		component = new KochComponent();
		component.setPreferredSize(new Dimension (C_WIDTH, C_HEIGHT));
		panel.add(component);
		
		add(panel);
	}
	
	private JButton makeNextButton()
	{
		JButton button = new JButton("Next");
		class ButtonListener implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
				component.next();
			}
		}
		button.addActionListener(new ButtonListener());
		return button;
	}
}














