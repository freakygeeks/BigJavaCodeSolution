//Chapter 26 - Exercise 26.15

import java.util.ArrayList;

public class InvoiceTester
{
	public static void main (String[] args) throws Exception
	{
		InvoiceParser p = new InvoiceParser();
		p.parse("invoice.xml");
	}
}