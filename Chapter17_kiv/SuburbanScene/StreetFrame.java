//Chapter 17 - Exercise 17.7

import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.util.Random;

public class StreetFrame extends JFrame
{
	private Street street;
	private Random gen;
	
	public StreetFrame()
	{
		street = new Street();
		gen = new Random();
		getContentPane().add(street, BorderLayout.CENTER);
		createControlPanel();
		pack();
	}
	
	public void createControlPanel()
	{
		final JComboBox shapeCombo = new JComboBox();
		final JComboBox colorCombo = new JComboBox();
		final JButton addButton = new JButton("Add");
		shapeCombo.addItem("House");
		shapeCombo.addItem("Car");
		colorCombo.addItem("Red");
		colorCombo.addItem("Green");
		colorCombo.addItem("Blue");
		colorCombo.addItem("Yellow");
		
		class AddButtonListener implements ActionListener
		{
			public void actionPerformed (ActionEvent event)
			{
				String shapeString = (String)shapeCombo.getSelectedItem();
				String colorString = (String)colorCombo.getSelectedItem();
				
				Color color = Color.black;
				
				if (colorString.equals("Red"))
				{
					color = Color.red;
				}
				
				else if (colorString.equals("Green"))
				{
					color = Color.green;
				}
				
				else if (colorString.equals("Blue"))
				{
					color = Color.blue;
				}
				
				else if (colorString.equals("Yellow"))
				{
					color = Color.yellow;
				}
				
				if (shapeString.equals("House"))
				{
					int houseX = gen.nextInt(getWidth());
					int houseY = 0;
					
					if (gen.nextBoolean())
					{
						houseY = 300 + gen.nextInt(getHeight());
						street.addHouse(new House(houseX, houseY, color));
					}
				}
				
				else if (shapeString.equals("Car"))
				{
					int carX = gen.nextInt(getWidth());
					int carY = 100 + gen.nextInt(70);
					street.addCar(new Car(carX, carY, color));
				}
			}
		}
		
		addButton.addActionListener(new AddButtonListener());
		JPanel comboPanel = new JPanel();
		comboPanel.add(shapeCombo);
		comboPanel.add(colorCombo);
		comboPanel.add(addButton);
		
		getContentPane().add(comboPanel, BorderLayout.SOUTH);
	}
}














