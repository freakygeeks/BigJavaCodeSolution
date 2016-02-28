//Chapter11 - Exercise P11.9

public class DataSet 
{
	private Comparable max;
	private Comparable min;
	
   public DataSet()
   {
   }

   public void add(Comparable x)
   {	
	if (max == null || x.compareTo(max) > 0)
		{
		max = x;
		}
		
	if (min == null || x.compareTo(min) < 0)
		{
		min = x;
		}
	}

	public Comparable getMaximum()
   {
	return max;
   }

   public Comparable getMinimum()
   {
	return min;
   }
}
