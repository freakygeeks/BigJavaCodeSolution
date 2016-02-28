//Chapter 26 - Exercise 26.17

public class Item
{  
   private int quantity;
   private Product theProduct;
   
   public Item(Product aProduct, int aQuantity)
   {  
      theProduct = aProduct;
      quantity = aQuantity;
   }
   
   /**
      Computes the total cost of this item.
      @return the total price
   */
   public double getTotalPrice()
   {  
      return theProduct.getPrice() * quantity;
   }
   
   /**
      Gets the product that this item describes.
      @return the product
   */
   public Product getProduct()
   {  
      return theProduct;
   }

   /**
      Gets the quantity of the product that this item describes.
      @return the quantity
   */
   public int getQuantity()
   {  
      return quantity;
   }

   /**
      Formats this item.
      @return a formatted string of this item
   */
   public String format()
   {  
      final int COLUMN_WIDTH = 30;
      String description = theProduct.getDescription();
           
      String r = description;

      // pad with spaces to fill column
      
      int pad = COLUMN_WIDTH - description.length();
      for (int i = 1; i <= pad; i++)
         r = r + " ";
   
      r = r + theProduct.getPrice()
         + "   " + quantity 
         + "   " + getTotalPrice();

      return r;
   }
}
