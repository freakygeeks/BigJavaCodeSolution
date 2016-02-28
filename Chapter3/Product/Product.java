//Chapter3 - Exercise P3.8
public class Product
{
	private String product1;
	private String product2;
	private double price1;
	private double price2;
	private double discount1;
	private double discount2;
	
	public Product()
	{
	product1 = " ";
	product2 = " ";
	price1 = 0;
	price2 = 0;
	discount1 = 0;
	discount2 = 0;
	}
	
	public void addProduct (String prod1, String prod2)
	{
	String newProd1 = this.product1 + prod1;
	this.product1 = newProd1;
	
	String newProd2 = this.product2 + prod2;
	this.product2 = newProd2;
	}
	
	public void addPrice (double amount1, double amount2)
	{
	double newPrice1 = this.price1 + amount1;
	double newPrice2 = this.price2 + amount2;
	this.price1 = newPrice1;
	this.price2 = newPrice2;
	}
	
	public void addDiscount (double rate)
	{
	double newDiscount1 = this.price1 - rate;
	this.discount1 = newDiscount1;
	
	double newDiscount2 = this.price2 - rate;
	this.discount2 = newDiscount2;
	}
	
	public String getProduct1()
	{
	return this.product1;
	}
	
	public String getProduct2()
	{
	return this.product2;
	}
	
	public double getPrice1()
	{
	return this.price1;
	}
	
	public double getPrice2()
	{
	return this.price2;
	}
	
	public double getDiscount1()
	{
	return this.discount1;
	}
	
	public double getDiscount2()
	{
	return this.discount2;
	}
}