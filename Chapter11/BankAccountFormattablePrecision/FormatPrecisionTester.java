//Chapter11 - Exercise P11.18

public class FormatPrecisionTester
{
   public static void main(String[] args)
   {
      BankAccount account1 = new BankAccount(1000);
      BankAccount account2 = new BankAccount(55);
      BankAccount account3 = new BankAccount(345);
      BankAccount account4 = new BankAccount(99000);

      System.out.printf("Result :   |%10s|%10s|%10s|%10s|%n", account1, account2, account3, account4);
      System.out.println("Precision: |    1000.0|      60.0|     350.0|   99000.0|");
   }
}