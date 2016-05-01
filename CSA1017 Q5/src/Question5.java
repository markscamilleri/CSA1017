import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by mark on 18/02/16.
 */
public class Question5 {
    public static void main(String[] args) {

        /*=========================== WELCOME USER ================================*/
        System.out.println("_____________________________________________________");
        System.out.println("|    CSA 1017 - Data Structures and Algorithms 1    |");
        System.out.println("|---------------------------------------------------|");
        System.out.println("|         Submission by Mark Said Camilleri         |");
        System.out.println("|       Task 5: Approximation of a Square Root      |");
        System.out.println("|---------------------------------------------------|");
        System.out.print("| Please enter a positive number to find its square root: ");

        //x1 and xn
        boolean isWrong = false;
        double input = 1;
        do {
            if (input <= 0) {
                System.out.println("| Your input was not accepted since it was \u2264 0");
                System.out.print("| Please enter a POSITIVE number to find its square root: ");
            } else System.out.print("| Your input was not accepted. Please try again: ");
            //x1 and xn
            try {
                input = new Scanner(System.in).nextDouble();
                isWrong = (input <= 0);
            } catch (InputMismatchException imme) {
                isWrong = true;
            }
        } while (isWrong);

        double curr_x = Math.random() * input + 1;
        double prev_x;

        int steps = 0;

        do {
            steps++;
            prev_x = curr_x;
            curr_x = prev_x - (Math.pow(prev_x, 2) - input) / (2 * prev_x);
        } while (curr_x != prev_x);

        System.out.println("|---------------------------------------------------|");
        char sign = (curr_x == Math.sqrt(input)) ? '=' : '\u2248';
        System.out.println("The square root of " + input + " " + sign + " " + curr_x);
        System.out.println("This was done in " + steps + " steps");
    }
}
