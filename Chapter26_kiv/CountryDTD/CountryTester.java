//Chapter 26 - Exercise 26.13

import java.util.ArrayList;

public class CountryTester
{
	public static void main (String[] args) throws Exception
	{
		CountryParser p = new CountryParser();
		ArrayList countryList = p.parse("countries.xml");
		CountryReport cr = new CountryReport(countryList);
		cr.report();
	}
}