//Chapter 17 - Exercise 17.3

public class Item
{
	private int quantity;
	private Product theProduct;
	
	public Item (Product aProduct, int aQuantity)
	{
		theProduct = aProduct;
		quantity = aQuantity;
	}
	
	public double getTotalPrice()
	{
		return theProduct.getPrice()*quantity;
	}
	
	public String getDescription()
	{
		return theProduct.getDescription();
	}
	
	public double getPrice()
	{
		return theProduct.getPrice();
	}
	
	public int getQuantity()
	{
		return quantity;
	}
}
