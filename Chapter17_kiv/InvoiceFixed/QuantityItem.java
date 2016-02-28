//Chapter 17 - Exercise 17.1

public class QuantityItem extends AbstractItem
{
	private int quantity;
	
	public QuantityItem(Product aProduct, int aQuantity)
	{
		super(aProduct);
		quantity = aQuantity;
	}
	
	public double getTotalPrice()
	{
		return getProduct().getPrice()*quantity;
	}
	
	public String format()
	{
		final int WIDTH = 30;
		String description = getProduct().getDescription();
		
		String r = description;
		int pad = WIDTH-description.length();
		
		for (int i = 1; i <= pad; i++)
		{
			r = r + " ";
		}
		
		r = r + getProduct().getPrice() + "   " + quantity + "   " + getTotalPrice();
		
		return r;
	}
}