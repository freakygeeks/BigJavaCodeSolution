//Chapter 14 - Exercise 14.9

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class RectangleSliderFrame extends JFrame
{
	private RectangleSliderPanel rectPanel;
	private JSlider countSlider;
	
	public RectangleSliderFrame()
	{
		rectPanel = new RectangleSliderPanel();
		getContentPane().add(rectPanel, BorderLayout.CENTER);
		createControlPanel();
		pack();
	}
	
	public void createControlPanel()
	{
		countSlider = new JSlider(0, 200, 100);
		
		class SliderListener implements ChangeListener
		{
			public void stateChanged(ChangeEvent event)
			{
				rectPanel.setCount(countSlider.getValue());
			}
		}
		
		ChangeListener listener = new SliderListener();
		countSlider.addChangeListener(listener);
		
		getContentPane().add(countSlider, BorderLayout.SOUTH);
		rectPanel.setCount(countSlider.getValue());
	}
}