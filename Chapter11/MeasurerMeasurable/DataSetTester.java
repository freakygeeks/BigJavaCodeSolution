//Chapter11 - Exercise P11.7

import java.awt.Rectangle;

public class DataSetTester
{
   public static void main(String[] args)
   {
      class RectangleMeasurer implements Measurer
      {
         public double measure(Object anObject)
         {
            Rectangle aRectangle = (Rectangle) anObject;
            double area = aRectangle.getWidth() * aRectangle.getHeight();
            return area;
         }
      }

      Measurer mInner = new RectangleMeasurer();
      DataSet data = new DataSet(mInner);

      data.add(new Rectangle(5, 10, 20, 30));
      data.add(new Rectangle(10, 20, 30, 40));
      data.add(new Rectangle(20, 30, 5, 10));

	  Object max = data.getMaximum();
	 
      System.out.println("Average rectangle area: " + data.getAverage()); //System.out.println("Expected: 616.6666667");
      System.out.println("Largest rectangle area: " + mInner.measure(max));//System.out.println("Expected: 1200");

      data = new DataSet();

      data.add(new BankAccount(2000));
      data.add(new BankAccount(200));
      data.add(new BankAccount(20000));
      
	  Measurable max2 = (Measurable) data.getMaximum();
	  
      System.out.println("Average account balance: " + data.getAverage());//System.out.println("Expected: 7400");
      System.out.println("Highest account balance: " + max2.getMeasure());//System.out.println("Expected: 20000");      
   }
}