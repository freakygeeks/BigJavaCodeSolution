/**
   An item in a phone book.
*/
public class Item
{
   /**
      Constructs an Item object.
      @param k the key string
      @param v the value of the item
   */
   public Item(String k, String v)
   { 
      key = k;
      value = v;
   }
   
   /**
      Gets the key.
      @return the key
   */
   public String getKey()
   { 
      return key;
   }
   
   /**
      Gets the value.
      @return the value
   */
   public String getValue()
   { 
      return value;
   }

   private String key;
   private String value;
}
