//Chapter 12 - Exercise 12.19

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

public class NByNGridViewer extends JComponent implements ActionListener
{
	private JTextField cField;
	private NByNGrid shape;

	public NByNGridViewer()
	{
		shape = new NByNGrid();
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
		
		inputPanel.add(new JLabel ("Enter count"));
		cField = new JTextField(5);
		inputPanel.add(cField);
		
		buttonPanel.add(inputPanel);
		
		JButton drawButton = new JButton ("Draw");
		drawButton.addActionListener(this);
		buttonPanel.add(drawButton);
		
		return buttonPanel;
	}
	
	public void actionPerformed (ActionEvent event)
	{
		int c;
	
		String cText = cField.getText();
		if(cText.equals(""))
			{
				c = 0;
			}
		else
			{
				c = Integer.parseInt(cText);
				System.out.println("testing count");
			}
		
		shape.setCount(c);
		shape.getCount();
		repaint();	
	}
	
	public static void main (String[] args)
	{
		JFrame frame = new JFrame();
		frame.setTitle("N-By-N Grid");
		
		NByNGridViewer component = new NByNGridViewer();
		Container contentPane = frame.getContentPane();
		contentPane.add(component, BorderLayout.CENTER);
		contentPane.add(component.createControlPanel(), BorderLayout.SOUTH);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(800,800));
		frame.setVisible(true);	
	}
}