public class Factors {

    public static void main(String[] args) { 

        // command-line argument
        long n = 10; //Long.parseLong(args[0]);

        System.out.print("The prime factorization of " + n + " is: ");

        // for each potential factor i
        for (long i = 1; i <= n / i; i++) {

            // if i is a factor of N, repeatedly divide it out
            while (n % i == 0) {
                System.out.print(i + " "); 
                n = n / i;
            }
        }

        // if biggest factor occurs only once, n > 1
        if (n > 1) System.out.println(n);
        else       System.out.println();
    }
}
