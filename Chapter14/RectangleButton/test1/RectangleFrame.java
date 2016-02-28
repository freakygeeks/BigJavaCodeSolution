import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RectangleFrame extends JFrame
{
	private RectanglePanel rectPanel;
	
	public RectangleFrame()
	{
		rectPanel = new RectanglePanel();
		
		getContentPane().add(rectPanel, BorderLayout.CENTER);
		createControlPanel();
		pack();
	}
	
	private void createControlPanel()
	{
		final JTextField xField = new JTextField(5);
		final JTextField yField = new JTextField(5);
		
		JButton moveButton = new JButton("Move");
		
		class MoveButtonListener implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
				int x = Integer.parseInt(xField.getText());
				int y = Integer.parseInt(yField.getText());
				rectPanel.moveBy(x, y );
			}
		}
		
		ActionListener listener = new MoveButtonListener();
		moveButton.addActionListener(listener);
		
		JLabel xLabel = new JLabel("x = ");
		JLabel yLabel = new JLabel("y = ");
		
		JPanel controlPanel = new JPanel();
		
		controlPanel.add(xLabel);
		controlPanel.add(xField);
		controlPanel.add(yLabel);
		controlPanel.add(yField);
		controlPanel.add(moveButton);
		
		getContentPane().add(controlPanel, BorderLayout.SOUTH);
	}
}















