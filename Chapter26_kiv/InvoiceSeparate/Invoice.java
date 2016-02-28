//Chapter 26 - Exercise 26.17

import java.util.ArrayList;

public class Invoice
{  
   private int number;
   private Address billingAddress;
   private Address shippingAddress;
   private ArrayList items;
   
   public Invoice(int aNumber, Address sAddress, Address bAddress)
   {  
      items = new ArrayList();
      number = aNumber;
      shippingAddress = sAddress;
      billingAddress = bAddress;
   }
  
   /**
      Adds a charge for a product to this invoice.
      @param aProduct the product that the customer ordered
      @param quantity the quantity of the product
   */
   public void add(Product aProduct, int quantity)
   {  
      Item anItem = new Item(aProduct, quantity);
      items.add(anItem);
   }

   /**
      Formats the invoice.
      @return the formatted invoice
   */
   public String format()
   {  
      String r =  "                     I N V O I C E\n\n"
         + billingAddress.format()
         + "\n\nDescription                   Price  Qty  Total\n";
      for (int i = 0; i < items.size(); i++)
      {  
         Item nextItem = (Item)items.get(i);
         r = r + nextItem.format() + "\n";
      }

      r = r + "\nAMOUNT DUE: $" + getAmountDue();

      return r;
   }

   /**
      Computes the total amount due.
      @return the amount due
   */
   public double getAmountDue()
   {  
      double amountDue = 0;
      for (int i = 0; i < items.size(); i++)
      {  
         Item nextItem = (Item)items.get(i);
         amountDue = amountDue + nextItem.getTotalPrice();
      }
      return amountDue;
   }

   /**
      Return list of items.
      @return the list of items
   */   
   public ArrayList getItems()
   {
      return items;
   }

   /**
      Return the invoice number.
      @return the invoice number
   */   
   public int getNumber()
   {
      return number;
   }

   /**
      Return the shipping address.
      @return the shipping address
   */   
   public Address getShippingAddress()
   {
      return shippingAddress;
   }

   /**
      Return the billing address.
      @return the billing address
   */   
   public Address getBillingAddress()
   {
      return billingAddress;
   }
}

