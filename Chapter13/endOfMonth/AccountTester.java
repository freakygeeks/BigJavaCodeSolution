//Chapter 13 - Exercise 13.8

public class AccountTester
{
   public static void main(String[] args)
   {
      SavingAccount momsSavings = new SavingAccount(5);
      CheckingAccount harrysChecking = new CheckingAccount(0);
      
      test(momsSavings);
      System.out.println(momsSavings.getBalance());      
      System.out.println("Expected: 6300");
      
      test(harrysChecking);
      System.out.println(harrysChecking.getBalance());      
      System.out.println("Expected: 5996");
   }

   public static void test(BankAccount account)
   {
      for (int i = 1; i <= 5; i++)
      {
         if (i % 2 == 1)
            account.deposit(i * 1000);
         else
            account.withdraw(i * 500);
      }

      account.endOfMonth();
   }
}