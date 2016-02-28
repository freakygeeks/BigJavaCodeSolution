//Chapter 17 - Exercise 17.3

import java.util.StringTokenizer;

public class InvoiceFormatter
{
	private Invoice invoice;
	private Address address;
	
	public InvoiceFormatter(Invoice anInvoice, Address anAddress)
	{
		invoice = anInvoice;
		address = anAddress;
	}
	
	public String invoiceFormat()
	{
		String r = "			I N V O I C E\n\n" + address.getName() + "\n" 
					+ address.getStreet() + "\n" + address.getCity() + "\n"
					+ address.getState() + "\n" + address.getZip() + "\n"
					+ "\n\nDescription			Price Qty Total\n";
		
		final int WIDTH = 30;
		
		for (int i = 0; i < invoice.getItemCount(); i++)
		{
			Item nextItem = invoice.getItem(i);
			String description = nextItem.getDescription();
			double price = nextItem.getPrice();
			int quantity = nextItem.getQuantity();
			
			r = r + description;
			int pad = WIDTH - description.length();
			
			for (int j = 1; j <= pad; j++)
			{
				r = r + " ";
			}
			
			r = r + price + "  " + quantity + "  " + nextItem.getTotalPrice() + "\n";
		}
		
		r = r + "\nAmount Due : $" + invoice.getAmountDue();
		
		return r;
	}
}















