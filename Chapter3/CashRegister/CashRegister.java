//Chapter3
/* A class to implement class register for purchase and payment
No main method, need to be execute using another class file*/
public class CashRegister
{
	private double change;
	/*create constructor to initialize the change in register*/
	public CashRegister()
	{
	change = 0;
	}
	/*create a method to calculate the amount of payment received */
	public void enterPayment(double amount)//mutator
	{
	double newPayment = change + amount;
	change = newPayment;
	}
	/*create a method to calculate the amount of purchase*/
	public void recordPurchase(double amount)//mutator
	{
	double newPurchase = change - amount;
	change = newPurchase;
	}
	/*get the current change of the payment*/
	public double giveChange()//assessor
	{
	return change;
	}
}