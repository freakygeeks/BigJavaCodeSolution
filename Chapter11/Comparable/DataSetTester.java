//Chapter11 - Exercise P11.9

public class DataSetTester
{
   public static void main(String[] args)
   {
      DataSet data = new DataSet();
   
      data.add("Robert");//50
      data.add("Vicky");//54 - max
	  data.add("Helen");//40
	  data.add("Andy");//33 - min

      Comparable max = data.getMaximum();
      Comparable min = data.getMinimum();
	  
      System.out.println("Maximum: " + max);
      System.out.println("Expected: Vicky");
      System.out.println("Minimum: " + min);
      System.out.println("Expected: Andy");
	  
   }
}