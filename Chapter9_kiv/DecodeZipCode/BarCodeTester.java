//Chapter 9 - Project 9.2

import javax.swing.JOptionPane;

public class BarCodeTester
{
	public static void main (String[] args)
	{
		String code = JOptionPane.showInputDialog("Please enter bar code : ");
		BarCode bc = new BarCode(code);
		int val = bc.getCode();
		
		if (val >= 0)
		{
			System.out.println("The zip code is : " + val);
		}
		else
		{
			System.out.println("Incorrect bar code data");
		}
		
		System.exit(0);
	}
}