//Chapter11 - Exercise P11.8

import java.awt.Rectangle;

public class DataSetTester
{
   public static void main(String[] args)
   {
	//for rectangle with measurer interface
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

	//for bank account with measurer interface
	   class BankMeasurer implements Measurer
      {
         public double measure(Object anObject)
         {
            BankAccount aBankAccount = (BankAccount) anObject;
            return aBankAccount.getBalance();
         }
      }

      class BankFilter implements Filter
      {
         public boolean accept(Object x)
         {
            BankAccount aBankAccount = (BankAccount) x;
            return aBankAccount.getBalance() > 1000;
         }
      }

      Measurer bankInner = new BankMeasurer();
      Filter filterInner = new BankFilter();
      DataSet dataBank = new DataSet(bankInner, filterInner);

      dataBank.addTest(new BankAccount(1));
      dataBank.addTest(new BankAccount(100));
      dataBank.addTest(new BankAccount(2000));
      dataBank.addTest(new BankAccount(950));
      dataBank.addTest(new BankAccount(4000));
           
      BankAccount b = (BankAccount) dataBank.getMaximum();
      double balance = b.getBalance();
	  
	  Object maxBank = dataBank.getMaximum();
	  
	  System.out.println("\nAverage account balance: " + dataBank.getAverage());//System.out.println("Expected: 3000"); //2000+4000/2 = 3000
      System.out.println("Highest account balance (>1000): " + balance);//System.out.println("Expected: 4000");
	  System.out.println("Highest account balance (>1000): " + bankInner.measure(maxBank));//System.out.println("Expected: 4000");
	  
	  //for bank account with measurable interface
      data = new DataSet();
	  
      data.add(new BankAccount(2000));
      data.add(new BankAccount(200));
      data.add(new BankAccount(20000));
	  data.add(new BankAccount(350));
      
	  Measurable max2 = (Measurable) data.getMaximum();
  
      System.out.println("\nAverage account balance: " + data.getAverage());//System.out.println("Expected: 11000");
      System.out.println("Highest account balance: " + max2.getMeasure() + "\n");//System.out.println("Expected: 20000");
   }
}