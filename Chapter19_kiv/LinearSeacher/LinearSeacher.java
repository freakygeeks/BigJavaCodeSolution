//Chapter 19 - Example 19.6

public class LinearSeacher
{
	private int[] a;
	
	public LinearSeacher(int[] anArray)
	{
		a = anArray;
	}
	
	public int search (int v)
	{
		for (int i = 0; i < a.length; i++)
		{
			if(a[i] == v)
			{
				return i;
			}
		}
		
		return -1;
	}
}