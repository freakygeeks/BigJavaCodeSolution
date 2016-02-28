//Chapter4 - Exercise P4.5 & P4.6
import java.util.Scanner;

public class DataSetTester
{
	public static void main (String[] args)
	{
	DataSet prog = new DataSet();
	Scanner in = new Scanner(System.in);
	
	System.out.println ("Enter 1st value : "); 
	double val1 = in.nextDouble();
	
	System.out.println ("Enter 2nd value : ");
	double val2 = in.nextDouble();
	
	System.out.println ("Enter 3rd value : ");
	double val3 = in.nextDouble();
	
	System.out.println ("Enter 4th value : ");
	double val4 = in.nextDouble();
	
	prog.addValue(val1);
	prog.addValue(val2);
	prog.addValue(val3);
	prog.addValue(val4);
	
	System.out.println ("The sum value is : " + prog.getSum());
	System.out.println ("The average value is : " + prog.getAverage());
	}
}