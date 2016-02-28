//Chapter 21 - Exercise 21.13

public class BinaryTreeSmallestTester
{
	public static void main (String[] args)
	{
		BinaryTreeSmallest staff = new BinaryTreeSmallest();
		staff.insert("Romeo");
		staff.insert("Juliet");
		staff.insert("Tom");
		staff.insert("Dick");
		staff.insert("Harry");
		
		System.out.println(staff.smallest());
	}
}