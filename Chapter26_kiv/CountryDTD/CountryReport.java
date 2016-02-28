//Chapter 26 - Exercise 26.13

import java.util.ArrayList;

public class CountryReport
{
	ArrayList countryList;
	
	public CountryReport (ArrayList countries)
	{
		countryList = countries;
	}
	
	//return the name of country that has largest area
	public String getLargestAreaCountry()
	{
		Country country = (Country)countryList.get(0);
		double largestArea = country.getArea();
		String name = country.getName();
		
		for (int i = 1; i < countryList.size(); i++)
		{
			country = (Country)countryList.get(i);
			
			if (largestArea < country.getArea())
			{
				largestArea = country.getArea();
				name = country.getName();
			}
		}
		return name;
	}
	
	//return the name of the country that has largest population
	public String getLargestPopulationCountry()
	{
		Country country = (Country)countryList.get(0);
		int largestPopulation = country.getPopulation();
		String name = country.getName();
		
		for (int i = 1; i < countryList.size(); i++)
		{
			country = (Country)countryList.get(i);
			if (largestPopulation < country.getPopulation())
			{
				largestPopulation = country.getPopulation();
				name = country.getName();
			}
		}
		return name;
	}
	
	//return the name of the country that has largest population density
	public String getLargestPopulationDensityCountry()
	{
		Country country = (Country)countryList.get(0);
		double largestPopulationDensity = country.getPopulationDensity();
		String name = country.getName();
		
		for (int i = 1; i < countryList.size(); i++)
		{
			country = (Country)countryList.get(i);
			if (largestPopulationDensity < country.getPopulationDensity())
			{
				largestPopulationDensity = country.getPopulationDensity();
				name = country.getName();
			}
		}
		return name;
	}
	
	//print out country report includes largest area, population and density
	public void report()
	{
		System.out.println("The country with the largest area : " + getLargestAreaCountry());
		System.out.println("The country with the largest population : " + getLargestPopulationCountry());
		System.out.println("The country with the largest population density : " + getLargestPopulationDensityCountry());
	}
}





























