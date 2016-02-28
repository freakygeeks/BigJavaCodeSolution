//Chapter 17 - Exercise 17.3

import java.util.ArrayList;

public class Invoice
{
	private ArrayList items;
	
	public Invoice()
	{
		items = new ArrayList();
	}
	
	public void add (Product aProduct, int quantity)
	{
		Item anItem = new Item (aProduct, quantity);
		items.add(anItem);
	}
	
	public double getAmountDue()
	{
		double amountDue = 0;
		
		for (int i = 0; i < items.size(); i++)
		{
			Item nextItem = (Item)items.get(i);
			amountDue = amountDue + nextItem.getTotalPrice();
		}
		
		return amountDue;
	}
	
	public Item getItem (int i)
	{
		return (Item)items.get(i);
	}
	
	public int getItemCount()
	{
		return items.size();
	}
}




















