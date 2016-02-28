//Chapter 16 - Project 16.1

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JFileChooser;
import java.io.Serializable;
import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CarFrame extends JFrame implements Serializable // frame with menu with commands to load and save a car file
{
	private CarPanel panel;
	
	public CarFrame()
	{
		panel = new CarPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		pack();
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.add(createFileMenu());
	}
	
	public JMenu createFileMenu()
	{
		JMenu menu = new JMenu("File");
		menu.add(createFileNewItem());
		menu.add(createFileOpenItem());
		menu.add(createFileSaveItem());
		menu.add(createFileExitItem());
		return menu;
	}
	
	public JMenuItem createFileNewItem()
	{
		JMenuItem item = new JMenuItem("New");
		
		class MenuItemListener implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
				panel.setCarData(new CarData());
			}
		}
		
		ActionListener listener = new MenuItemListener();
		item.addActionListener(listener);
		return item;
	}
	
	public JMenuItem createFileOpenItem()
	{
		JMenuItem item = new JMenuItem ("Open");
		
		class MenuItemListener implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
				try
				{
					JFileChooser chooser = new JFileChooser();
					
					if (chooser.showOpenDialog(null) == JFileChooser.CANCEL_OPTION)
					{
						return;
					}
					
					ObjectInputStream in = new ObjectInputStream(new FileInputStream(chooser.getSelectedFile()));
					CarData data = (CarData)in.readObject();
					in.close();
					panel.setCarData(data);
				}
				
				catch (IOException exception)
				{
					System.out.println(exception);
				}
				
				catch (ClassNotFoundException exception)
				{
					System.out.println (exception);
				}
			}
		}
		
		ActionListener listener = new MenuItemListener();
		item.addActionListener(listener);
		return item;
	}

	public JMenuItem createFileSaveItem()
	{
		JMenuItem item = new JMenuItem("Save");
		
		class MenuItemListener implements ActionListener
		{
			public void actionPerformed (ActionEvent event)
			{
				try
				{
					JFileChooser chooser = new JFileChooser();
					
					if (chooser.showSaveDialog(null) == JFileChooser.CANCEL_OPTION)
					{
						return;
					}
					
					ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(chooser.getSelectedFile()));
					out.writeObject(panel.getCarData());
					out.close();
				}
				
				catch (IOException exception)
				{
					System.out.println(exception);
				}
				
				repaint();
			}
		}
		
		ActionListener listener = new MenuItemListener();
		item.addActionListener(listener);
		return item;
	}
	
	public JMenuItem createFileExitItem()
	{
		JMenuItem item = new JMenuItem("Exit");
		
		class MenuItemListener implements ActionListener
		{
			public void actionPerformed (ActionEvent event)
			{
				System.exit(0);
			}
		}
		
		ActionListener listener = new MenuItemListener();
		item.addActionListener(listener);
		return item;
	}
}






















































































