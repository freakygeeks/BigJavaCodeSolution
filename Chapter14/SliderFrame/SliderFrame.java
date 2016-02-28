//Chapter 14 - Example 14.6

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class SliderFrame extends JFrame
{
	private JPanel colorPanel;
	private JSlider redSlider;
	private JSlider greenSlider;
	private JSlider blueSlider;
	
	private static final int WIDTH = 300;
	private static final int HEIGHT = 400;
	
	public SliderFrame()
	{
		colorPanel = new JPanel();
		
		add(colorPanel, BorderLayout.CENTER);
		createControlPanel();
		setSampleColor();
		setSize(WIDTH, HEIGHT);
	}
	
	public void createControlPanel()
	{
		class ColorListener implements ChangeListener
		{
			public void stateChanged (ChangeEvent event)
			{
				setSampleColor();
			}
		}
		
		ChangeListener listener = new ColorListener();
		
		redSlider = new JSlider(0, 100, 100);
		redSlider.addChangeListener(listener);
		
		greenSlider = new JSlider(0, 100, 70);
		greenSlider.addChangeListener(listener);
		
		blueSlider = new JSlider(0, 100, 70);
		blueSlider.addChangeListener(listener);
		
		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(new GridLayout(3,2));
		
		controlPanel.add(new JLabel("Red"));
		controlPanel.add(redSlider);
		
		controlPanel.add(new JLabel("Green"));
		controlPanel.add(greenSlider);
		
		controlPanel.add(new JLabel("Blue"));
		controlPanel.add(blueSlider);
		
		add(controlPanel, BorderLayout.SOUTH);
	}
	
	//read slider value and set panel to select color
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



























