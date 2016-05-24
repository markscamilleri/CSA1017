import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Mark Said Camilleri
 * @version 20160523
 */
public class Question9 {
    public static void main(String[] args) {
        /*=============================== WELCOME USER ===========================*/
        System.out.println("_____________________________________________________");
        System.out.println("|    CSA 1017 - Data Structures and Algorithms 1    |");
        System.out.println("|---------------------------------------------------|");
        System.out.println("|         Submission by Mark Said Camilleri         |");
        System.out.println("|         Task 9: Sum of Fibonacci Sequence         |");
        System.out.println("|---------------------------------------------------|");

        /*====== ASK USER FOR INPUT ======*/
        Scanner in = new Scanner(System.in);
        int n = -1;

        do {
            //Asks user for number of terms
            System.out.println("| Please input the number of terms to calculate the |");
            System.out.print("| sum of: ");

            try {
                n = in.nextInt();

                //Only accept positive integers for this.
                if (n < 1) {
                    System.out.println("|   Your input was not accepted. Please try again   |");
                }
            } catch (InputMismatchException ime) {
                //If input is wrong
                System.out.println("|   Your input was not accepted. Please try again   |");
                n = 0;
                in.nextLine();
            }
        } while (n < 1);

        double result = fibsum(n);
        System.out.printf("| The sum to the first %-5d terms is: %-12g |\n", n, result);
        System.out.println("‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾");

    }

    /**
     * Method that returns the sum of the fibonacci numbers up to
     * and including the nth term.
     *
     * @param n The number of terms of fibonacci sequence to find the
     *          sum of
     * @return The sum of the fibonacci numbers up to and including
     * the nth term
     */
    public static double fibsum(int n) {
        /*
         * 1st and 2nd term respectively these are (i-2)th and
         * (i-1)th terms respectively.
         */
        double fib1 = 0;
        double fib2 = 1;

        //Base cases, since the pattern is based on the first 2 terms.
        if (n == 1) return fib1;
        else if (n == 2) return fib2;
        else {
            //Result of the sum of the first 2 terms, to add to it.
            double result = 1;
            for (int i = 3; i <= n; i++) {
                //ith term of fib sequence
                double fib = fib1 + fib2;
                result += fib;

                //Shifts (i-1)th term to (i-2)th term
                fib1 = fib2;
                //Shifts ith term to (i-1)th term
                fib2 = fib;
            }
            //Sum of fibonacci sequence is returned
            return result;
        }
    }
}
