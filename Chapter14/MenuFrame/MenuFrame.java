//Chapter 14 - Example 14.4

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class MenuFrame extends JFrame
{
	private JLabel sampleField;
	private String facename;
	private int fontstyle;
	private int fontsize;

	private static final int WIDTH = 300;
	private static final int HEIGHT = 400;
	
	/*construct the frame*/
	public MenuFrame()
	{
		sampleField = new JLabel ("Big Java");
		add(sampleField, BorderLayout.CENTER);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.add(createFileMenu());
		menuBar.add(createFontMenu());
		
		facename = "Serif";
		fontsize = 24;
		fontstyle = Font.PLAIN;
		
		setSampleFont();
		setSize(WIDTH, HEIGHT);
	}
	
	/*set font of text sample*/
	public void setSampleFont()
	{
		Font f = new Font(facename, fontstyle, fontsize);
		sampleField.setFont(f);
		sampleField.repaint();
	}
	
	/*create file menu*/
	public JMenu createFileMenu()
	{
		JMenu menu = new JMenu("File");
		menu.add(createFileExitItem());
		
		return menu;
	}
	
	/*create File>Exit menu item and set its action listener*/
	public JMenuItem createFileExitItem()
	{
		JMenuItem item = new JMenuItem("Exit");
		
		class MenuItemListener implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
				System.exit(0);
			}
		}
		
		ActionListener listener = new MenuItemListener();
		item.addActionListener(listener);
		
		return item;
	}
	
	/*create font submenu*/
	public JMenu createFontMenu()
	{
		JMenu menu = new JMenu("Font");
		menu.add(createFaceMenu());
		menu.add(createSizeMenu());
		menu.add(createStyleMenu());
		
		return menu;
	}
	
	/*create face submenu*/
	public JMenu createFaceMenu()
	{
		JMenu menu = new JMenu("Face");
		menu.add(createFaceItem("Serif"));
		menu.add(createFaceItem("SansSerif"));
		menu.add(createFaceItem("MonoSpaced"));
		
		return menu;
	}
	
	/*create size submenu*/
	public JMenu createSizeMenu()
	{
		JMenu menu = new JMenu("Size");
		menu.add(createSizeItem("Smaller", -1));
		menu.add(createSizeItem("Larger", 1));
		
		return menu;
	}
	
	/*create style submenu*/
	public JMenu createStyleMenu()
	{
		JMenu menu = new JMenu("Style");
		menu.add(createStyleItem("Plain", Font.PLAIN));
		menu.add(createStyleItem("Bold", Font.BOLD));
		menu.add(createStyleItem("Italic", Font.ITALIC));
		menu.add(createStyleItem("Bold Italic", Font.BOLD + Font.ITALIC));
		
		return menu;
	}
	
	/*create menu item to change font face and set its action listener*/
	public JMenuItem createFaceItem(final String name)
	{
		JMenuItem item = new JMenuItem(name);
		
		class MenuItemListener implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
				facename = name;
				setSampleFont();
			}
		}
		
		ActionListener listener = new MenuItemListener();
		item.addActionListener(listener);
		
		return item;
	}
	
	/*create menu to change font size and set its action listener*/
	public JMenuItem createSizeItem(String name, final int ds)
	{
		JMenuItem item = new JMenuItem(name);
		
		class MenuItemListener implements ActionListener
		{
			public void actionPerformed (ActionEvent event)
			{
				fontsize = fontsize + ds;
				setSampleFont();
			}
		}
		
		ActionListener listener = new MenuItemListener();
		item.addActionListener(listener);
		
		return item;
	}
	
	/*create menu item to change font style and set its action listener*/
	public JMenuItem createStyleItem(String name, final int style)
	{
		JMenuItem item = new JMenuItem(name);
		
		class MenuItemListener implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
				fontstyle = style;
				setSampleFont();
			}
		}
		
		ActionListener listener = new MenuItemListener();
		item.addActionListener(listener);
		
		return item;
	}	
	

}



















































