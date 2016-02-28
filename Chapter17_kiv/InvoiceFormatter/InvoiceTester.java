//Chapter 17 - Exercise 17.3

public class InvoiceTester
{
	public static void main (String[] args)
	{
		Address samAddress = new Address ("Sam's Small Appliances", "100 Main Street", "Anytown", "CA", "98765");
		
		Invoice samInvoice = new Invoice();
		samInvoice.add(new Product("Toaster", 29.95), 3);
		samInvoice.add(new Product("Hair Dryer", 24.95), 1);
		samInvoice.add(new Product("Car Vacuum", 19.99), 2);
		
		InvoiceFormatter format = new InvoiceFormatter(samInvoice, samAddress);
		System.out.println(format.invoiceFormat());
	}
}