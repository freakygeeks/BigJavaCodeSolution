//Chapter4 - Exercise P4.11
import java.util.Scanner;

public class CashRegisterGiveChangeTester
{
	public static void main (String[] args)
	{
	CashRegisterGiveChange calc = new CashRegisterGiveChange();
	Scanner in = new Scanner(System.in);
	
	System.out.println ("Please enter the purchase value : ");
	double pur = in.nextDouble();
	
	System.out.println ("Please enter the payment value : ");
	System.out.println ("Dollar payment : ");
	double dollar = in.nextDouble();
	System.out.println ("Quarter payment : ");
	double quarter = in.nextDouble();
	System.out.println ("Dime payment : ");
	double dime = in.nextDouble();
	System.out.println ("Nickel payment : " );
	double nickel = in.nextDouble();
	System.out.println ("Penny payment : ");
	double penny = in.nextDouble();
	
	calc.addPurchase (pur);
	calc.addPayment(dollar, quarter, dime, nickel, penny);
	
	System.out.println ("Total change is : " + calc.getChange());
	System.out.println ("Dollar : " + calc.returnDollar());
	System.out.println ("Quarter : " +calc.returnQuarter());
	System.out.println ("Dime : " + calc.returnDime());
	System.out.println ("Nickel : " + calc.returnNickel());
	System.out.println ("Penny : " + calc.returnPenny());
	}
}