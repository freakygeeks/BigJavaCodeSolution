import java.util.Scanner;

public class FibonacciSeries {

   public static void main(String[] args) {
       Scanner s = new Scanner(System.in);
       System.out.print("Enter the value of n: ");
       int n = s.nextInt();
       fibonacci(n);
   }

   public static void fibonacci(int n) {
       if (n == 0) {
           System.out.println("0");
       } else if (n == 1) {
           System.out.println("0 1");
       } else {
           System.out.print("0 1 ");
           int a = 0;
           int b = 1;
           for (int i = 1; i < n; i++) {
               int nextNumber = a + b;
			   a = b;
               b = nextNumber;
               System.out.print(nextNumber + " ");
           }
       }
   }
}
