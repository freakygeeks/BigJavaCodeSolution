//Chapter 17 - Example 17.4

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