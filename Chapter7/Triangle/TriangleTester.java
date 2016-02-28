//Chapter7 - Example 7.3

public class TriangleTester
{
	public static void main (String[] args)
	{
	Triangle calc1 = new Triangle(3);
	System.out.println (calc1.toString1());
	
	Triangle calc2 = new Triangle(15);
	System.out.println (calc2.toString1());
	
	Triangle calc3 = new Triangle(3);
	System.out.println (calc1.toString2());
	
	Triangle calc4 = new Triangle(15);
	System.out.println (calc2.toString2());
	}
}