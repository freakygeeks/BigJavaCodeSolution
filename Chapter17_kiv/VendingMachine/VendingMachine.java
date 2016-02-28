//Chapter 17 - Exercise 17.9

import java.util.ArrayList;

public class VendingMachine
{
	private ArrayList products;
	private ArrayList productTypes;
	public CoinSet coins;
	public CoinSet currentCoins;
	
	public VendingMachine()
	{
		products = new ArrayList();
		productTypes = new ArrayList();
		coins = new CoinSet();
		currentCoins = new CoinSet();
	}
	
	public void printProductTypes()
	{
		for (int i = 0; i < productTypes.size(); i++)
		{
			Product type = (Product)productTypes.get(i);
			type.print();
		}
	}
	
	//add coin to vending machine
	public void addCoin (Coin c)
	{
		currentCoins.addCoin(c);
	}
	
	//buy product from vending machine
	public void buyProduct (String description)
	{
		for (int i = 0; i < products.size(); i++)
		{
			Product p = (Product)products.get(i);
			
			if (p.getPrice() <= currentCoins.getValue())
			{
				products.remove(i);
				coins.addCoins(currentCoins);
				currentCoins.removeAllCoins();
				p.print();
				return;
			}
			
			else
			{
				System.out.println("Insufficient money");
				return;
			}
		}
		
		System.out.println("No such product");
	}
	
	public void addProduct (Product p, int quantity)
	{
		for (int i = 0; i < quantity; i++)
		{
			products.add(p);
		}
		
		for (int i = 0; i < productTypes.size(); i++)
		{
			Product type = (Product)productTypes.get(i);
			if (type.equals(p))
			{
				return;
			}
		productTypes.add(p);
		}
	}
	
	public void removeMoney()
	{
		System.out.println ("Removed &" + coins.getValue());
		coins.removeAllCoins();
	}
}






























