//Chapter 17 - Exercise 17.9

import java.util.ArrayList;

public class Product
{
	private String description;
	private double price;
	
	public Product (String aDescription, double aPrice)
	{
		description = aDescription;
		price = aPrice;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public double getPrice()
	{
		return price;
	}
	
	public boolean equals (Object other)
	{
		if (other == null)
		{
			return false;
		}
		
		Product b = (Product) other;
		return description.equals(b.description) && price == b.price;
	}
	
	public void print()
	{
		System.out.println (description + " @ $" + price);
	}	
}











