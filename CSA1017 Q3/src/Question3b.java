import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by mark on 12/02/16.
 */
public class Question3b {

    private static Scanner in;

    public static void main(String args[]) {

        //Initialize Scanner object
        in = new Scanner(System.in).useDelimiter("\n");

        System.out.println("_____________________________________________________");
        System.out.println("|    CSA 1017 - Data Structures and Algorithms 1    |");
        System.out.println("|---------------------------------------------------|");
        System.out.println("|         Submission by Mark Said Camilleri         |");
        System.out.println("|           Task 3b: Sieve of Eratosthenes          |");
        System.out.println("|---------------------------------------------------|");
        System.out.print("| Please enter a number to check: ");

        int prime = in.nextInt();

        if (isPrime(prime)) System.out.printf("| %31d is a prime number |\n", prime);
        else System.out.printf("| %27d is not a prime number |\n", prime);

    }

    private static boolean isPrime(int prime) {
        boolean[] nos = new boolean[prime];

        Arrays.fill(nos, true);

        for (int i = 1; i <= prime; i++) {
            if (i == 1) nos[i - 1] = false;
            else if (nos[i - 1]) {
                for (int j = i + i; j <= prime; j += i) {
                    nos[j - 1] = false;
                }
            }
            if (!nos[prime - 1]) break;
        }
        System.out.println("|---------------------------------------------------|");
        return nos[prime - 1];
    }
}
