//Chapter 17 - Exercise 17.1

import java.util.ArrayList;

public class Invoice
{
	private Address billingAddress;
	private ArrayList items;
	private String header;
	
	public Invoice(Address anAddress)
	{
		items = new ArrayList();
		billingAddress = anAddress;
		header = " ";
	}
	
	public void add (Product aProduct, int quantity)
	{
		QuantityItem anItem = new QuantityItem (aProduct, quantity);
		items.add(anItem);
		header = "Qty";
	}
	
	public void add (Product aProduct, double aShippingCharge)
	{
		FixedItem anItem = new FixedItem (aProduct, aShippingCharge);
		items.add(anItem);
		header = "Shp";
	}
	
	public String format()
	{
		String heading = "				I N V O I C E\n" + billingAddress.format();
		String r = "\n\nDescription			Price " + header + " Total\n";
		
		for (int i = 0; i < items.size(); i++)
		{
			AbstractItem nextItem = (AbstractItem)items.get(i);
			r = r + nextItem.format() + "\n";
		}
		
		r = r + "\nAMOUNT DUE : $" + getAmountDue();
		
		return heading + r;
	}
	
	public double getAmountDue()
	{
		double amountDue = 0;
		
		for (int i = 0; i < items.size(); i++)
		{
			AbstractItem nextItem = (AbstractItem)items.get(i);
			amountDue = amountDue + nextItem.getTotalPrice();
		}
		
		return amountDue;
	}
}



















