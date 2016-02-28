//Chapter 9 - Project 9.2

import javax.swing.JOptionPane;

public class BarCodeTester
{
	public static void main (String[] args)
	{
		String input = JOptionPane.showInputDialog("Please enter a five-digit zip code : ");
		int num = Integer.parseInt(input);
		
		BarCode bc = new BarCode(num);
		String code = bc.getCode();
		
		System.out.println("The barcode of the zip is : " + code);
		System.exit(0);
	}
}