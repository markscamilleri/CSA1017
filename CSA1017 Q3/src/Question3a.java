/**
 * Created by mark on 10/02/16.
 */

import java.util.Scanner;

public class Question3a {

    public static void main(String args[]){

        //Initialize Scanner object
        Scanner in = new Scanner(System.in).useDelimiter("\n");

        System.out.println("_____________________________________________________");
        System.out.println("|    CSA 1017 - Data Structures and Algorithms 1    |");
        System.out.println("|---------------------------------------------------|");
        System.out.println("|         Submission by Mark Said Camilleri         |");
        System.out.println("|            Task 3a: Prime Number Checker          |");
        System.out.println("|---------------------------------------------------|");
        System.out.print("| Please enter a number to check: ");

        long prime = in.nextLong();

        System.out.println("|---------------------------------------------------|");
        if(isPrime(prime)) System.out.printf("| %31d is a prime number |\n",prime);
        else System.out.printf("| %27d is not a prime number |\n",prime);

    }

    private static boolean isPrime(long prime) {
        if (prime == 1) return false;
        else if (prime % 2 == 0) return false;
        else {
            double root = Math.sqrt(prime);
            for (int i = 3; i <= root; i+=2) {
                if (prime % i == 0) return false;
            }
            return true;
        }
    }
}
