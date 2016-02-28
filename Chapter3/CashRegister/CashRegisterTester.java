//Chapter3
/*A class to to test and execute method in CashRegister class*/
public class CashRegisterTester
{
	/*To test the method of CashRegister class*/
	public static void main (String[] args)
	{
	/*create the constructor CashRegister*/
	CashRegister reg = new CashRegister();
	/*invoked method to calculate total of purchasing*/
	reg.recordPurchase(29.50);
	reg.recordPurchase(9.25);
	/*invoked method to calculate total of payment received*/
	reg.enterPayment(50);
	/*invoked the method of "giveChange" */
	double result = reg.giveChange();
	/*print out the result*/
	System.out.println (result);
	}
}
	