//Chapter 26 - Exercise 26.17

public class Address
{  
   private String name;
   private String company;
   private String street;
   private String city;
   private String state;
   private String zip;
   
   public Address(String aName, String aCompany, String aStreet, String aCity, String aState, String aZip)
   {  
      name = aName;
      company = aCompany;
      street = aStreet;
      city = aCity;
      state = aState;
      zip = aZip;
   }   

   /**
      Formats the address.
      @return the address as a string with 3 lines
   */
   public String format()
   {  
      return name + "\n" + street + "\n"
         + city + ", " + state + " " + zip;
   }

   /**
      Return the name.
      @return the name
   */      
   public String getName()
   {
      return name;
   }

   /**
      Return the company.
      @return the company
   */
   public String getCompany()
   {
      return company;
   }

   /**
      Return the street.
      @return the street
   */
   public String getStreet()
   {
      return street;
   }

   /**
      Return the city.
      @return the city
   */
   public String getCity()
   {
      return city;
   }

   /**
      Return the state.
      @return the state
   */
   public String getState()
   {
      return state;
   }

   /**
      Return the zip.
      @return the zip
   */
   public String getZip()
   {
      return zip;
   }
}
