//Chapter 17 - Example 17.4

import java.util.ArrayList;

public class Invoice
{	
	private ArrayList<LineItem> items; //create an arraylist for line item to store many line item at the same time
	private Address billingAddress;

	public Invoice(Address anAddress)
	{
		items = new ArrayList<LineItem>();
		billingAddress = anAddress;
	}
	
	public void add (Product aProduct, int quantity)
	{
		LineItem anItem = new LineItem(aProduct, quantity); //call lineitem class with its info
		items.add(anItem); //store the lineitem info in the arraylist
	}
	
	public String format()
	{
		String r = "			I N V O I C E\n\n" + billingAddress.format() + String.format("\n\n%-30s%8s%5s%8s\n", "Description", "Price", "Qty", "Total");
		
		for (LineItem i : items)
		{
			r = r + i.format() + "\n";
		}
		
		return r;
	}
	
	public double getAmountDue()
	{
		double amountDue = 0;
		for (LineItem i : items)
		{
			amountDue = amountDue + i.getTotalPrice();
		}
		
		return amountDue;
	}
}