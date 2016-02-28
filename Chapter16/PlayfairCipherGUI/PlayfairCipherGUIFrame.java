//Chapter 16 - Exercise 16.12

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PlayfairCipherGUIFrame extends JFrame
{
	private PlayfairCipherGUI panel;
	private JTextArea result;
	private JTextField keyword;
	private JButton inputButton;
	private JButton outputButton;
	private JButton submitButton;
	private File inputFile;
	private File outputFile;
	
	public PlayfairCipherGUIFrame()
	{
		panel = new PlayfairCipherGUI();
		getContentPane().add(panel, BorderLayout.CENTER);
		createControlPanel();
		pack();
	}
	
	private void createControlPanel()
	{
		//show result text
		final int ROW = 5;
		final int COL = 30;
		
		result = new JTextArea(ROW, COL);
		result.setEditable(false);
		JScrollPane scrollText = new JScrollPane(result);
		
		//set text for keyword
		keyword = new JTextField(10);
		
		//button to choose input file, output file and submit
		inputButton = new JButton ("Input File");
		outputButton = new JButton ("Output File");
		submitButton = new JButton ("Submit");
		
		//listener for inputButton to open file
		class InputListener implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
					JFileChooser chooser = new JFileChooser();
					
					int option = chooser.showOpenDialog(PlayfairCipherGUIFrame.this);
					
					if (option == JFileChooser.APPROVE_OPTION)
					{
						inputFile = chooser.getSelectedFile();
					}
			}
		}
		
		ActionListener inputListen = new InputListener();
		inputButton.addActionListener(inputListen);
		
		//listener for outputButton to save file
		class OutputListener implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
				JFileChooser chooser = new JFileChooser();
				
				int option = chooser.showSaveDialog(PlayfairCipherGUIFrame.this);
				
				if (option == JFileChooser.APPROVE_OPTION)
				{
					outputFile = chooser.getSelectedFile();
				}
			}
		}
		
		ActionListener outputListen = new OutputListener();
		outputButton.addActionListener(outputListen);
		
		//listener for text keyword and submit button
		class KeywordButtonListener implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
				String word = keyword.getText();
				
				try
				{
				panel.getKey(word);
				panel.processFile(inputFile, outputFile);
				result.setText("Input file : " + inputFile + "\n" + "Output file : " + outputFile + "\n" + "Processing...\n" + "Completed! Please view your output file");
				}
				
				catch (IOException exception)
				{
					System.out.println(exception);
				}
			}
		}
		
		ActionListener keybutListen = new KeywordButtonListener();
		submitButton.addActionListener(keybutListen);
		
		//display the result text area
		JPanel northPanel = new JPanel();
		northPanel.add(result);
		add(northPanel, BorderLayout.CENTER);
		
		//display the text field and button 
		JPanel southPanel = new JPanel();
		southPanel.add(new JLabel ("Keyword"));
		southPanel.add(keyword);
		southPanel.add(inputButton);
		southPanel.add(outputButton);
		southPanel.add(submitButton);
		add(southPanel, BorderLayout.SOUTH);
	}
}