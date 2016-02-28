//Chapter 14 - Exercise 14.13

import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class SliderTickMarks extends JFrame
{
	private JPanel colorPanel;
	private JSlider redSlider;
	private JSlider greenSlider;
	private JSlider blueSlider;
	private static final int WIDTH = 300;
	private static final int HEIGHT = 300;
	
	
	public SliderTickMarks()
	{
		colorPanel = new JPanel();
		colorPanel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		getContentPane().add(colorPanel, BorderLayout.CENTER);
		createControlPanel();
		setSampleColor();
		pack();
	}
	
	public void createControlPanel()
	{
		class ColorListener implements ChangeListener
		{
			public void stateChanged(ChangeEvent event)
			{
				setSampleColor();
			}
		}
		
		ColorListener listener = new ColorListener();
		
		redSlider = new JSlider(0, 100, 100);
		redSlider.addChangeListener(listener);
		redSlider.setMajorTickSpacing(10);
		redSlider.setMinorTickSpacing(5);
		redSlider.setPaintTicks(true);
		
		
		greenSlider = new JSlider(0, 100, 70);
		greenSlider.addChangeListener(listener);
		greenSlider.setMajorTickSpacing(10);
		greenSlider.setMinorTickSpacing(5);
		greenSlider.setPaintTicks(true);
		
		
		blueSlider = new JSlider(0, 100, 70);
		blueSlider.addChangeListener(listener);
		blueSlider.setMajorTickSpacing(10);
		blueSlider.setMinorTickSpacing(5);
		blueSlider.setPaintTicks(true);
		
		//fill content pane
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new GridLayout(3,2));
		southPanel.add(new JLabel ("Red", SwingConstants.RIGHT));
		southPanel.add(redSlider);
		southPanel.add(new JLabel ("Green", SwingConstants.RIGHT));
		southPanel.add(greenSlider);
		southPanel.add(new JLabel ("Blue", SwingConstants.RIGHT));
		southPanel.add(blueSlider);
		
		getContentPane().add(southPanel, BorderLayout.SOUTH);
		setSampleColor();
	}
	
	public void setSampleColor()
	{
		//read slider values
		float red = 0.01F*redSlider.getValue();
		float green = 0.01F*greenSlider.getValue();
		float blue = 0.01F*blueSlider.getValue();
		
		//set panel background to selected color
		colorPanel.setBackground(new Color(red, green, blue));
		colorPanel.repaint();
	}	
}










































































