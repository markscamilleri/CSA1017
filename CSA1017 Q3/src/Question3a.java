import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Mark Said Camilleri
 * @version 20160511
 */

public class Question3a {

    public static void main(String args[]) {

        //Initialize Scanner object
        Scanner in = new Scanner(System.in).useDelimiter("\n");

        /*======================== WELCOME MESSAGE TO USER =======================*/
        System.out.println("_____________________________________________________");
        System.out.println("|    CSA 1017 - Data Structures and Algorithms 1    |");
        System.out.println("|---------------------------------------------------|");
        System.out.println("|         Submission by Mark Said Camilleri         |");
        System.out.println("|            Task 3a: Prime Number Checker          |");
        System.out.println("|---------------------------------------------------|");
        System.out.print("| Please enter an integer to check: ");

        try {
            //The number to check whether or not it's prime
            long prime = in.nextLong();

            System.out.println("|---------------------------------------------------|");
            if (isPrime(prime))
                System.out.printf("| %31d is a prime number |\n", prime);
            else
                System.out.printf("| %27d is not a prime number |\n", prime);

            System.out.println("‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾");
        } catch (InputMismatchException ime) {
            System.out.println("| Your input was not accepted. Please restart the   |");
            System.out.println("| program and try again with a valid input.         |");
            System.out.println("‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾");
            System.exit(1);
        }
    }

    /**
     * This method checks the input parameter to see if it is a prime
     * number or not.
     *
     * @param prime The number to check if it is prime
     * @return true if the number is prime, false if it isn't
     */
    private static boolean isPrime(long prime) {
        /*Firstly, if the number is 1, 0 or negative then it's not
         * prime
         */
        if (prime <= 1) return false;
            //If the number is 2, 2 is prime.
        else if (prime == 2) return true;
            //If the number is even and not 2, then it's not prime.
        else if (prime % 2 == 0) return false;
        /* Otherwise, divide this number by all odd numbers till the
         * square root of the number. If one is divisible then it's
         * not prime.
         */
        else {
            double root = Math.sqrt(prime);
            for (int i = 3; i <= root; i += 2) {
                if (prime % i == 0) return false;
            }
            return true;
        }
    }
}
