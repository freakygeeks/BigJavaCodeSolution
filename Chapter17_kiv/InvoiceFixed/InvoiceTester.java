//Chapter 17 - Exercise 17.1

public class InvoiceTester
{
	public static void main (String[] args)
	{
		Address samAddress = new Address ("Sam's Small Appliances", "100 Main Street", "Anytown", "CA", "98765");
		
		Invoice samInvoice = new Invoice(samAddress);
		samInvoice.add(new Product("Toaster", 29.95), 3);
		samInvoice.add(new Product("Hair Dryer", 24.95), 1);
		samInvoice.add(new Product("Car Vacuum", 19.99), 2);
		
		System.out.println(samInvoice.format());
		
		Address edsAddress = new Address ("Ed's Small Appliances", "101 Main Street", "Anytown", "CA", "98765");
	
		Invoice edsInvoice = new Invoice(edsAddress);
		edsInvoice.add(new Product("Toaster", 24.95), 3.5);
		edsInvoice.add(new Product("Hair Dryer", 19.95), 1.0);
		edsInvoice.add(new Product("Car Vacuum", 19.99), 4.5);
		
		System.out.println(edsInvoice.format());
	}
}