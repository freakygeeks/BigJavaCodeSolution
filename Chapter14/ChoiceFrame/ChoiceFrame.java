//Chapter 14 - Example 14.3

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
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class ChoiceFrame extends JFrame
{
	private JLabel sampleField;
	private JCheckBox italicCheckBox;
	private JCheckBox boldCheckBox;
	private JRadioButton smallButton;
	private JRadioButton mediumButton;
	private JRadioButton largeButton;
	private JComboBox facenameCombo;
	private ActionListener listener;
	
	private static final int WIDTH = 300;
	private static final int HEIGHT = 400;
	
	/*contains text field and a control panel to change font text*/
	public  ChoiceFrame()
	{
		sampleField = new JLabel ("Big Java");
		add(sampleField, BorderLayout.CENTER);
		
		class ChoiceListener implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
				setSampleFont();
			}
		}
		
		listener = new ChoiceListener();
		createControlPanel();
		setSampleFont();
		setSize(WIDTH, HEIGHT);
	}
	
	/*creates control panel to change font*/
	public void createControlPanel()
	{
		JPanel facenamePanel = createComboBox();
		JPanel sizeGroupPanel = createCheckBox();
		JPanel styleGroupPanel = createRadioButton();
		
		/*line up component panels*/
		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(new GridLayout(3,1));
		controlPanel.add(facenamePanel);
		controlPanel.add(sizeGroupPanel);
		controlPanel.add(styleGroupPanel);
		
		/*add panel to content pane*/
		add(controlPanel, BorderLayout.SOUTH);
	}
	
	/*get user choice for font, name, style, size and sets font of text*/
	public void setSampleFont()
	{
		//get font name using getSelectedItem()
		String facename = (String) facenameCombo.getSelectedItem();
		
		//get font style using isSelected()
		int style = 0;
		if (italicCheckBox.isSelected())
			{
				style = style + Font.ITALIC;
			}
		if (boldCheckBox.isSelected())
			{
				style = style + Font.BOLD;
			}
			
		//get font size using isSelected()
		int size = 0;
		final int SMALL = 24;
		final int MEDIUM = 36;
		final int LARGE = 48;
		
		if (smallButton.isSelected())
			{
				size = SMALL;
			}
		if (mediumButton.isSelected())
			{
				size = MEDIUM;
			}
		if (largeButton.isSelected())
			{
				size = LARGE;
			}
			
		//set font of text field
		sampleField.setFont(new Font(facename, style, size));
		sampleField.repaint();
	}
	
	/*create combo box with font style choices*/
	public JPanel createComboBox()
	{
		//type of font and then apply it in listener interface
		facenameCombo = new JComboBox();
		facenameCombo.addItem("Serif");
		facenameCombo.addItem("SansSerif");
		facenameCombo.addItem("Monospaced");
		facenameCombo.setEditable(true);
		facenameCombo.addActionListener(listener);
		
		JPanel panel = new JPanel();
		panel.add(facenameCombo);
		panel.setBorder(new TitledBorder(new EtchedBorder(), "Font Type"));
		
		return panel;
	}
	
	/*create check boxes for selecting bold and italic style*/
	public JPanel createCheckBox()
	{
		//style of font and then apply it in listener interface
		italicCheckBox = new JCheckBox("Italic");
		italicCheckBox.addActionListener(listener);
		
		boldCheckBox = new JCheckBox("Bold");
		boldCheckBox.addActionListener(listener);
		
		JPanel panel = new JPanel();
		panel.add(italicCheckBox);
		panel.add(boldCheckBox);
		panel.setBorder(new TitledBorder(new EtchedBorder(), "Style"));
		
		return panel;
	}
	
	/*create radio button to select font size*/
	public JPanel createRadioButton()
	{
		//size of font and then apply it in listeber interface
		smallButton = new JRadioButton("Small");
		smallButton.addActionListener(listener);
		
		mediumButton = new JRadioButton("Medium");
		mediumButton.addActionListener(listener);
		
		largeButton = new JRadioButton("Large");
		mediumButton.addActionListener(listener);
		
		/*add radio button to group*/
		ButtonGroup group = new ButtonGroup();
		group.add(smallButton);
		group.add(mediumButton);
		group.add(largeButton);
				
		JPanel panel = new JPanel();
		panel.add(smallButton);
		panel.add(mediumButton);
		panel.add(largeButton);
		panel.setBorder(new TitledBorder(new EtchedBorder(), "Size"));
		
		return panel;
	}
}















































