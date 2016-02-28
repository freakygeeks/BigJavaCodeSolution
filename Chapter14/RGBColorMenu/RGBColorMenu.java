//Chapter 14 - Exercise 14.7

import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;

public class RGBColorMenu extends JFrame
{
	private JPanel colorPanel;
	private Color aColor;
	private static final int WIDTH = 300;
	private static final int HEIGHT = 300;
	
	public RGBColorMenu()
	{
		colorPanel = new JPanel();
		colorPanel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		getContentPane().add(colorPanel, BorderLayout.CENTER);
		
		//create menu at top
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.add(createFileMenu());
		menuBar.add(createColorMenu());

		pack();
	}
	
	//create File Menu
	public JMenu createFileMenu()
	{
		JMenu menu = new JMenu("File");
		menu.add(createFileExitItem());
		return menu;
	}
	
	//create action for File --> Exit menu
	public JMenuItem createFileExitItem()
	{
		JMenuItem item = new JMenuItem("Exit");
		class ExitListener implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
				System.exit(0);
			}
		}
		
		ActionListener listener = new ExitListener();
		item.addActionListener(listener);
		return item;
	}
	
	//create Color Menu
	public JMenu createColorMenu()
	{
		JMenu menu = new JMenu("Color");
		menu.add(createColor("Red", Color.red));
		menu.add(createColor("Green", Color.green));
		menu.add(createColor("Blue", Color.blue));
		return menu;
	}
	
	//create action to change color
	public JMenuItem createColor(String name, final Color color)
	{
		JMenuItem item = new JMenuItem(name);
		class ColorListener implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
				aColor = color;
				setColor();
			}
		}

		ActionListener listener = new ColorListener();
		item.addActionListener(listener);
		return item;
	}
	
	//create color to be selected
	public void setColor()
	{
		colorPanel.setBackground(aColor);
	}	
}














































