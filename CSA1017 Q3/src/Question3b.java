import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by mark on 12/02/16.
 */
public class Question3b {

    public static void main(String args[]) {

        //Initialize Scanner object
        Scanner in = new Scanner(System.in).useDelimiter("\n");

        /*======================== WELCOME MESSAGE TO USER =======================*/
        System.out.println("_____________________________________________________");
        System.out.println("|    CSA 1017 - Data Structures and Algorithms 1    |");
        System.out.println("|---------------------------------------------------|");
        System.out.println("|         Submission by Mark Said Camilleri         |");
        System.out.println("|           Task 3b: Sieve of Eratosthenes          |");
        System.out.println("|---------------------------------------------------|");
        System.out.print("| Please enter a number to check: ");

        /*
         * Value to check if it's prime. Note that this is now an int
         * since the Sieve or Eratosthenes requires an array of this
          * amount of elements.
         */
        int prime = in.nextInt();

        System.out.println("|---------------------------------------------------|");
        if (isPrime(prime)) System.out.printf("| %31d is a prime number |\n", prime);
        else System.out.printf("| %27d is not a prime number |\n", prime);

    }

    /**
     * Runs the Sieve of Eratosthenes algorithm to check if the input
     * is a prime number or not.
     *
     * @param prime The number to check if it is prime or not.
     * @return true if the input is prime, false if it isn't.
     */
    private static boolean isPrime(int prime) {

        //Each ith element is true if i-1 is prime. False otherwise.
        boolean[] nos = new boolean[prime];

        //We begin by assuming all the values are prime.
        Arrays.fill(nos, true);

        //Then, 1 is crossed out since it is a square.
        nos[0] = false;

        /*
         * After which each value is checked. i is assumed to be prime
         * unless marked as not prime. Multiples of i are not prime.
         * Therefore all the multiples of i are marked as not prime.
         * This keeps going on until the inputted value is set to not
         * prime or reached and still set to prime.
         */
        for (int i = 2; i <= prime; i++) {
            //Checks if i is marked as prime.
            if (nos[i - 1]) {
                //If it is, all multiples of i are marked as not prime
                for (int j = i + i; j <= prime; j += i) {
                    nos[j - 1] = false;
                }
            }
            /*
             * If the inputted value is marked as prime, we can stop
             * there since we found out whether it's prime or not.
             * Otherwise, this program keeps going on till the end
             * (i = prime).
             */
            if (!nos[prime - 1]) break;
        }

        return nos[prime - 1];
    }
}
