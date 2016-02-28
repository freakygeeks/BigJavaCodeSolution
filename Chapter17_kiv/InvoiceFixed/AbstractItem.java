//Chapter 17 - Exercise 17.1

public abstract class AbstractItem
{
	private Product theProduct;
	
	public AbstractItem(Product aProduct)
	{
		theProduct = aProduct;
	}
	
	public Product getProduct()
	{
		return theProduct;
	}
	
	public abstract double getTotalPrice();
	public abstract String format();
	
}