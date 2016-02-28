//Chapter3 - Exercise P3.8
public class ProductTester
{
	public static void main (String[] args)
	{
	Product prod = new Product();
	prod.addProduct("Pensel", "Pen");
	prod.addPrice (6, 10);
	prod.addDiscount (5);
	
	String newProd1 = prod.getProduct1();
	String newProd2 = prod.getProduct2();
	double newPrice1 = prod.getPrice1();
	double newPrice2 = prod.getPrice2();
	double newDiscount1 = prod.getDiscount1();
	double newDiscount2 = prod.getDiscount2();
	
	System.out.println ("The product are : " + newProd1 + " and " + newProd2);
	System.out.println ("The price are : " + newPrice1 + " and " + newPrice2);
	System.out.println ("Price reduce to : " + newDiscount1 + " and " + newDiscount2);
	}
}