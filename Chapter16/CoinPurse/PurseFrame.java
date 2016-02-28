//Chapter 16 - Exercise CoinPurse

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.text.*;

public class PurseFrame extends JFrame
{
	private JLabel label;
	private Purse purse;
	private static double NICKEL = 0.05;
	private static double DIME = 0.1;
	private static double QUARTER = 0.25;
	
	public PurseFrame()
	{
		purse = new Purse();
		label = new JLabel();
		setLabelText();
		getContentPane().add(label, BorderLayout.CENTER);
		
		JMenuBar bar = new JMenuBar();
		setJMenuBar(bar);
		bar.add(createFileMenu());
		bar.add(createAddMenu());
		pack();
	}
	
	//create file menu
	public JMenu createFileMenu()
	{
		JMenu menu = new JMenu("File");
		menu.add(createFileOpenItem());
		menu.add(createFileSaveItem());
		menu.add(createFileExitItem());
		
		return menu;
	}
	
	//create add menu
	public JMenu createAddMenu()
	{
		JMenu menu = new JMenu("Add");
		menu.add(createAddItem(new Coin(NICKEL, "nickel")));
		menu.add(createAddItem(new Coin(DIME, "dime")));
		menu.add(createAddItem(new Coin(QUARTER, "quarter")));
		
		return menu;
	}
	
	//create File->Open menu item and set action listener
	public JMenuItem createFileOpenItem()
	{
		JMenuItem item = new JMenuItem("Open");
		class MenuItemListener implements ActionListener
		{
			public void actionPerformed (ActionEvent event)
			{
				try 
				{
					JFileChooser chooser = new JFileChooser();
					
					if (chooser.showOpenDialog(null) == JFileChooser.CANCEL_OPTION)
					{
						return;
					}
					
					ObjectInputStream in = new ObjectInputStream(new FileInputStream(chooser.getSelectedFile()));
					purse = (Purse)in.readObject();
					in.close();
					setLabelText();					
				}
				
				catch (IOException exception)
				{
					exception.printStackTrace();
				}
				
				catch (ClassNotFoundException exception)
				{
					exception.printStackTrace();
				}
			}
		}
		
		ActionListener listener = new MenuItemListener();
		item.addActionListener(listener);
		return item;
	}
	
	//create File->Save menu item and set action listener
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
					out.writeObject(purse);
					out.close();
					setLabelText();			
				}
				
				catch (IOException exception)
				{
					System.out.println(exception);
				}
				//repaint();
			}
		}
		
		ActionListener listener = new MenuItemListener();
		item.addActionListener(listener);
		return item;
	}
	
	//create File->Exit menu item and set action listener
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
	
	//create File->Coin menu item and set action listener
	public JMenuItem createAddItem (final Coin coin)
	{
		JMenuItem item = new JMenuItem(coin.getName());
		class MenuItemListener implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
				purse.add(coin);
				setLabelText();
			}
		}
		
		ActionListener listener = new MenuItemListener();
		item.addActionListener(listener);
		return item;
	}
	
	//set the label text to purse total
	public void setLabelText()
	{
		double totalValue = purse.getTotal();
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		label.setText("Total value is " + formatter.format(totalValue));
	}
	
}



















































