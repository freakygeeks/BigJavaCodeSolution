//Chapter3 - Project 3.2
public class GreeterTester
{
	public static void main (String[] args)
	{
	Greeter hi = new Greeter();
	hi.sayHello1("World!");
	hi.sayHello2("Dave!");
	
	String H1 = hi.getHello1();
	String H2 = hi.getHello2();
	String H3 = hi.getGoodbye1();
	String H4 = hi.getGoodbye2();
	String H5 = hi.getRefuse();
	
	System.out.println (H1);
	System.out.println (H2);
	System.out.println (H3);
	System.out.println (H4);
	System.out.println (H5);
	}
}