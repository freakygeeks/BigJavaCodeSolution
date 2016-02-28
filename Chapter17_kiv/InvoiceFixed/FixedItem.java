//Chapter 17 - Exercise 17.1

public class FixedItem extends AbstractItem
{
	private double shipping;
	
	public FixedItem (Product aProduct, double aShippingCharge)
	{
		super(aProduct);
		shipping = aShippingCharge;
	}
	
	public double getTotalPrice()
	{
		return getProduct().getPrice() + shipping;
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
		
		r = r + getProduct().getPrice() + "  " + shipping + "  " + getTotalPrice();
		
		return r;
	}
}