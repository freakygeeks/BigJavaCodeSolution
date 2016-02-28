//Chapter 26 - Exercise 26.17

public class Product
{  
   private String description;
   private double price;
   
   public Product(String aDescription, double aPrice)
   {  
      description = aDescription;
      price = aPrice;
   }
   
   /**
      Gets the product description.
      @return the description
   */
   public String getDescription()
   {  
      return description;
   }

   /**
      Gets the product price.
      @return the unit price
   */
   public double getPrice()
   {
      return price;
   }
}
