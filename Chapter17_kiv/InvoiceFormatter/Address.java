//Chapter 17 - Exercise 17.3

public class Address
{
	private String name;
	private String street;
	private String city;
	private String state;
	private String zip;
	
	public Address (String aName, String aStreet, String aCity, String aState, String aZip)
	{
		name = aName;
		street = aStreet;
		city = aCity;
		state = aState;
		zip = aZip;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getStreet()
	{
		return street;
	}
	
	public String getCity()
	{
		return city;
	}
	
	public String getState()
	{
		return state;
	}
	
	public String getZip()
	{
		return zip;
	}
}