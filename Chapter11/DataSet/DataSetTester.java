//Chapter11 - Example 11.1

public class DataSetTester
{
	public static void main (String[] args)
	{
	DataSet bankData = new DataSet();

	bankData.add(new BankAccount(0));
	bankData.add(new BankAccount(10000));
	bankData.add(new BankAccount(2000));
		
	Maximum max = bankData.getMax();
	
	System.out.println("Average balance for Bank Account = " + bankData.getAverage());
	System.out.println("Highest balance for Bank Account = " + max.getMax());
	
	DataSet coinData = new DataSet();
	
	coinData.add(new CashRegister(500));
	coinData.add(new CashRegister(150));
	coinData.add(new CashRegister(345));
	coinData.add(new CashRegister(700));
	
	max = coinData.getMax();
	
	System.out.println("Average purchase for Cash Register = " + coinData.getAverage());
	System.out.println("Highest purchase for Cash Register = " + max.getMax());
	}
}