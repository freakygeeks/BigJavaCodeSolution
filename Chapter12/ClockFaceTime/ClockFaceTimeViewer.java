//Chapter 12 - Exercise 12.18

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ClockFaceTimeViewer extends JComponent implements ActionListener
{
	private JTextField hField;
	private JTextField mField;
	private ClockFaceTime shape;

	public ClockFaceTimeViewer()
	{
		shape = new ClockFaceTime();
	}
	
	public void paintComponent (Graphics g)
	{
		super.paintComponent(g);
		shape.paint(g);
	}
	
	private Component createControlPanel()
	{
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout (buttonPanel, BoxLayout.Y_AXIS));
	
		JPanel inputPanel =new JPanel();
		
		inputPanel.add(new JLabel ("Enter hour"));
		hField = new JTextField(2);
		inputPanel.add(hField);
		
		inputPanel.add(new JLabel ("Enter minutes"));
		mField = new JTextField(2);
		inputPanel.add(mField);
	
		buttonPanel.add(inputPanel);
		
		JButton drawButton = new JButton ("Draw");
		drawButton.addActionListener(this);
		buttonPanel.add(drawButton);
		
		return buttonPanel;
	}
	
	public void actionPerformed (ActionEvent event)
	{
		int h;
		int m;
		
		String hText = hField.getText();
		if(hText.equals(""))
			{
				h = 0;
			}
		else
			{
				h = Integer.parseInt(hText);
				System.out.println("testing hour");
			}
		shape.setHour(h);

		String mText = mField.getText();		
		if(mText.equals(""))
			{
				m = 0;
			}
		else
			{
				m = Integer.parseInt(mText);
				System.out.println("testing minutes");
			}
		shape.setMinutes(m);
		
		shape.getMinutes();
		shape.getHour();
		repaint();	
	}
	
	public static void main (String[] args)
	{
		JFrame frame = new JFrame();
		frame.setTitle("Clock Face Time");
		
		ClockFaceTimeViewer component = new ClockFaceTimeViewer();
		Container contentPane = frame.getContentPane();
		contentPane.add(component, BorderLayout.CENTER);
		contentPane.add(component.createControlPanel(), BorderLayout.SOUTH);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(800,800));
		frame.setVisible(true);	
	}
}