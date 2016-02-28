//Chapter4 - Exercise P4.6
import java.util.Scanner;

public class DataSetMaxMinTester
{
	public static void main (String[] args)
	{
	DataSetMaxMin calc = new DataSetMaxMin();
	Scanner in = new Scanner(System.in);
	
	System.out.println ("Please enter 1st number : ");
	int val1 = in.nextInt();
	
	System.out.println ("Please enter 2nd number : ");
	int val2 = in.nextInt();
	
	System.out.println ("Please enter 3rd number : ");
	int val3 = in.nextInt();
	
	System.out.println ("Please enter 4th number : ");
	int val4 = in.nextInt();
	
	calc.addValue(val1);
	calc.addValue(val2);
	calc.addValue(val3);
	calc.addValue(val4);
	
	System.out.println ("The largest number is : " + calc.getLargest());
	System.out.println ("The smallest number is : " + calc.getSmallest());
	System.out.println ("The sum is : " + calc.getSum());
	System.out.println ("The average is : " + calc.Average());
	}
}