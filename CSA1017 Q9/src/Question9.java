import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by mark on 28/04/16.
 */
public class Question9 {
    public static void main(String[] args) {
        System.out.println("_____________________________________________________");
        System.out.println("|    CSA 1017 - Data Structures and Algorithms 1    |");
        System.out.println("|---------------------------------------------------|");
        System.out.println("|         Submission by Mark Said Camilleri         |");
        System.out.println("|         Task 9: Sum of Fibonacci Sequence         |");
        System.out.println("|---------------------------------------------------|");

        /*================= ASK USER FOR EXPRESSION INPUT ========================*/
        Scanner in = new Scanner(System.in);
        int n = -1;

        do {
            System.out.println("| Please input the number of terms to calculate the |");
            System.out.print("| sum of: ");

            try{
               n = in.nextInt();
            }catch (InputMismatchException ime){
                System.out.println("|   Your input was not accepted. Please try again   |");
                n = -1;
                in.nextLine();
            }
        }while(n == -1);

        double result = fibsum(n);
        System.out.printf("| The sum to the first %-5d terms is: %-12g |\n",n,result);
        System.out.println("‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾");

    }

    public static double fibsum(int n){
        double result = 0;
        double fib1 = 0;
        double fib2 = 1;

        for (int i = 1; i <= n; i++) {
            double fib = fib1 + fib2;
            result += fib;

            fib1 = fib2;
            fib2 = fib;
        }

        return result;
    }
}
