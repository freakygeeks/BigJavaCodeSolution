//Chapter4
public class StampMachineTester
{
	public static void main (String[] args)
	{
	StampMachine stamp = new StampMachine();
	stamp.insert(1);
	
	System.out.println ("First class stamps : " + stamp.giveFirstClassStamp());
	System.out.println ("Penny stamps : " + stamp.givePennyStamp());
	}
}