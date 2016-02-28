//Chapter 14 - Project 14.1

import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

public class ChartFrame extends JFrame
{
	private BarChart b;
	private PieChart p;
	private BarChartPanel graphPanelBar;
	private PieChartPanel graphPanelPie;
	private JRadioButton barButton;
	private JRadioButton pieButton;
	private Color aColor;
	private ActionListener listenerCombo;
	private ActionListener listenerRadio;
	
	public ChartFrame()
	{
		graphPanelBar = new BarChartPanel();
		graphPanelPie = new PieChartPanel();
		getContentPane().add(graphPanelBar, BorderLayout.WEST);
		getContentPane().add(graphPanelPie, BorderLayout.EAST);
		
		createControlPanel();
		pack();
	}
	
	public void createControlPanel()
	{				
		JButton addButton = new JButton("Add Item");
		
		final JTextField nameField = new JTextField();
		final JTextField lengthField = new JTextField("10");
		final JComboBox colorCombo = new JComboBox();
		colorCombo.addItem("Red");
		colorCombo.addItem("Green");
		colorCombo.addItem("Blue");		
		
		JRadioButton barButton = new JRadioButton("Bar Chart");
		barButton.addActionListener(listenerRadio);
		
		JRadioButton pieButton = new JRadioButton("Pie Chart");
		pieButton.addActionListener(listenerRadio);
		
		ButtonGroup group = new ButtonGroup();
		group.add(barButton);
		group.add(pieButton);

		JPanel panel = new JPanel();
		panel.add(barButton);
		panel.add(pieButton);
		
		class ButtonListener implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
				String name = nameField.getText();
				int length = Integer.parseInt(lengthField.getText());
				Color c = Color.black;
				String color = (String)colorCombo.getSelectedItem();
				
				if (color.equals("Red"))
				{
					c = Color.red;
				}
				else if (color.equals("Green"))
				{
					c = Color.green;
				}
				else if (color.equals("Blue"))
				{
					c = Color.blue;
				}
				
				b = new BarChart (name, length, c);
				graphPanelBar.addBar(b);
				
				p = new PieChart (name, length, c);
				graphPanelPie.addPie(p);
				
			}
		}
		
		ActionListener listenerCombo = new ButtonListener();
		addButton.addActionListener(listenerCombo);
		
		class RadioListener implements ActionListener
		{
			public void actionPerformed (ActionEvent event)
			{
				if (barButton.isSelected())
				{
					getContentPane().add(graphPanelBar, BorderLayout.CENTER);
				}
				else if (pieButton.isSelected())
				{
					getContentPane().add(graphPanelPie, BorderLayout.CENTER);
				}
			}
		}
		
		RadioListener listenerRadio = new RadioListener();
		barButton.addActionListener(listenerRadio);
		pieButton.addActionListener(listenerRadio);
		
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new GridLayout(4,2));
		northPanel.add(new JLabel("Label"));
		northPanel.add(nameField);
		northPanel.add(new JLabel("Number"));
		northPanel.add(lengthField);
		northPanel.add(new JLabel("Color"));
		northPanel.add(colorCombo);
		northPanel.add(barButton);
		northPanel.add(pieButton);
		
		JPanel southPanel = new JPanel();
		southPanel.add(addButton);
				
		getContentPane().add(northPanel, BorderLayout.NORTH);
		getContentPane().add(southPanel, BorderLayout.SOUTH);
	}
}




