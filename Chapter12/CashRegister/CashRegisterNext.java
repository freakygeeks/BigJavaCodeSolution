//Chapter 12 - Project 12.1

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CashRegisterNext
{
	private static final int WIDTH = 450;
	private static final int HEIGHT = 300;
	
	public static void main (String[] args)
	{
		final Purse aPurse = new Purse();
		final Coin aQuarter = new Coin(0.25, "Quarter");
		final Coin aDime 	= new Coin(0.10, "Dime");
		final Coin aNickel 	= new Coin(0.05, "Nickel");
		final Coin aPenny 	= new Coin(0.01, "Penny");
	
		final int FIELD = 3;
		
		JFrame frame = new JFrame();
		
		//for 1st values
		JLabel numOne = new JLabel ("Item 1 : Price");
		final JTextField numOneField = new JTextField(FIELD);
		numOneField.setText(" ");
		
		//for 2nd values
		JLabel numTwo = new JLabel ("Item 1 : Price");
		final JTextField numTwoField = new JTextField(FIELD);
		numTwoField.setText(" ");
		
		//for 3rd values
		JLabel numThree = new JLabel ("Item 1 : Price");
		final JTextField numThreeField = new JTextField(FIELD);
		numThreeField.setText(" ");
	
		//button to enter
		JButton dataButton = new JButton ("Total");
				
		final JLabel sumPrice = new JLabel ("Price : ");
		
		//for 1st values
		JLabel quarter = new JLabel ("Quarter");
		final JTextField quarterField = new JTextField(FIELD);
		quarterField.setText(" ");
		
		//for 2nd values
		JLabel dime = new JLabel ("Dime");
		final JTextField dimeField = new JTextField(FIELD);
		dimeField.setText(" ");
		
		//for 3rd values
		JLabel nickel = new JLabel ("Nickel");
		final JTextField nickelField = new JTextField(FIELD);
		nickelField.setText(" ");
		
		//for 4rd values
		JLabel penny = new JLabel ("Penny");
		final JTextField pennyField = new JTextField(FIELD);
		pennyField.setText(" ");
		
		//button to enter
		JButton paymentButton = new JButton ("Payment");
		
		final JLabel sumPayment = new JLabel ("Cash : ");
		final JLabel sumChange = new JLabel ("Change : ");
		
		JPanel panel = new JPanel();
		panel.add(numOne);
		panel.add(numOneField);
		panel.add(numTwo);
		panel.add(numTwoField);
		panel.add(numThree);
		panel.add(numThreeField);
		panel.add(dataButton);
		panel.add(sumPrice);
		panel.add(quarter);
		panel.add(quarterField);
		panel.add(dime);
		panel.add(dimeField);
		panel.add(nickel);
		panel.add(nickelField);
		panel.add(penny);
		panel.add(pennyField);
		panel.add(paymentButton);
		panel.add(sumPayment);
		panel.add(sumChange);
		frame.add(panel);
		
		//listener for dataSet
		class CashRegisterListener implements ActionListener
		{
			public void actionPerformed (ActionEvent event)
			{
				double one = Double.parseDouble(numOneField.getText());
				double two = Double.parseDouble(numTwoField.getText());
				double three = Double.parseDouble(numThreeField.getText());
					
				double totalSum = one + two + three;
				sumPrice.setText("Price : " + totalSum);
				
				double q = 0;
				double d = 0;
				double n = 0;
				double p = 0;
			
				q = Double.parseDouble(quarterField.getText());
				d = Double.parseDouble(dimeField.getText());
				n = Double.parseDouble(nickelField.getText());
				p = Double.parseDouble(pennyField.getText());
				
				double aQ = aQuarter.getValue()*q;
				double aD = aDime.getValue()*d;
				double aN = aNickel.getValue()*n;
				double aP = aPenny.getValue()*p;
				
				double totalPayment = aQ + aD + aN + aP;
				sumPayment.setText("Cash : " + totalPayment);
				
				double change = totalPayment - totalSum;
				sumChange.setText("Change : " + change);
				
				/*aPurse.add(aQuarter);
				aPurse.add(aDime);
				aPurse.add(aNickel);
				aPurse.add(aPenny);
				aPurse.getTotal();
				sumPayment.setText("Cash : " + aPurse.getTotal());*/
			}		
		}
		
		//callback listener
		CashRegisterListener listener = new CashRegisterListener();
		dataButton.addActionListener(listener);
		paymentButton.addActionListener(listener);
		
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
}