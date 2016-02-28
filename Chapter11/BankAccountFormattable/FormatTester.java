//Chapter11 - Exercise P11.17

public class FormatTester
{
   public static void main(String[] args)
   {
      BankAccount account1 = new BankAccount(1000);
      BankAccount account2 = new BankAccount(55);
      BankAccount account3 = new BankAccount(345);
      BankAccount account4 = new BankAccount(99000);

      System.out.printf("Result :  |%10s|%10s|%10s|%10s|%n", account1, account2, account3, account4);
      System.out.println("Expected: |    1000.0|      55.0|     345.0|   99000.0|");
   }
}