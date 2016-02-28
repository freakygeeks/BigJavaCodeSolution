//Chapter 17 - Exercise 17.3

public class Product
{
	private String description;
	private double price;
	
	public Product(String aDescription, double aPrice)
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
}