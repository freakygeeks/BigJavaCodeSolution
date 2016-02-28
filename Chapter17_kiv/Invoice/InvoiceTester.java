//Chapter 17 - Example 17.4

public class InvoiceTester
{
	public static void main (String[] args)
	{
		Address samAddress = new Address ("Sam's Small Appliance", "100 Main Street", "Anytown", "CA", "98765");
		
		Invoice samInvoice = new Invoice(samAddress);
		samInvoice.add(new Product("Toaster", 29.95), 3);
		samInvoice.add(new Product("Hair Dryer", 24.95), 1);
		samInvoice.add(new Product("Car vacuum", 19.99), 2);
		
		System.out.println(samInvoice.format());
	}
}