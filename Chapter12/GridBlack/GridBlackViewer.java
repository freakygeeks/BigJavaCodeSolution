//Chapter 12 - Exercise 12.20

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GridBlackViewer extends JComponent implements MouseListener
{
	private JTextField cField;
	private GridBlack shape;

	public GridBlackViewer()
	{
		shape = new GridBlack();
	}
	
	public void paintComponent (Graphics g)
	{
		super.paintComponent(g);
		shape.paint(g);
		shape.setCount();
		shape.getCount();
	}
	
	private Component createControlPanel()
	{
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout (buttonPanel, BoxLayout.Y_AXIS));
	
		JPanel inputPanel =new JPanel();
		addMouseListener(this);
		
		return buttonPanel;
	}
	
	public void mousePressed (MouseEvent event)
	{
		int x = event.getX();
		int y = event.getY();
		
		/*int c;
		String cText = cField.getText();
		if(cText.equals(""))
			{
				c = 0;
			}
		else
			{
				c = Integer.parseInt(cText);
				System.out.println("testing count");
			}*/
		
		shape.setPaint(x, y);
		repaint();	
	}
	
	public void mouseReleased (MouseEvent event)
	{
	}
			
	public void mouseClicked(MouseEvent event)
	{
	}
			
	public void mouseEntered (MouseEvent event)
	{
	}
			
	public void mouseExited (MouseEvent event)
	{
	}
	
	public static void main (String[] args)
	{
		JFrame frame = new JFrame();
		frame.setTitle("N-By-N Grid");
		
		GridBlackViewer component = new GridBlackViewer();
		Container contentPane = frame.getContentPane();
		contentPane.add(component, BorderLayout.CENTER);
		contentPane.add(component.createControlPanel(), BorderLayout.SOUTH);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(800,800));
		frame.setVisible(true);	
	}
}