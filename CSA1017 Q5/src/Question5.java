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

        //variable to state whether input should be accepted or not.
        boolean isWrong = false;

        //input variable. This shall be x1 and the first value of xn,
        double input = 1;
        do {
            try {
                //accpets user input.
                input = new Scanner(System.in).nextDouble();

                /*
                 * If the value is not positive, then it will raise an
                 * error
                 */
                if (input <= 0) {
                    isWrong = true;
                    System.out.println("| Your input was not accepted since it was \u2264 0");
                    System.out.print("| Please enter a POSITIVE number to find its square root: ");
                }

                //It will also raise an error if it's not a number.
            } catch (InputMismatchException imme) {
                isWrong = true;
                System.out.print("| Your input was not accepted. Please try again: ");
            }
            //This is repeated until a correct value was inputted.
        } while (isWrong);

        //Setting the first value for x_n
        double curr_x = Math.random() * input + 1;
        //Initializing x_(n-1)
        double prev_x;

        //Counts the number of steps taken.
        int steps = 0;

        do {
            steps++;
            prev_x = curr_x;

            //Newton-Raphson formula on y=sqrt(x)
            curr_x = prev_x - (Math.pow(prev_x, 2) - input) / (2 * prev_x);
            /*
             * This will keep on, either until there has been no change
             * or until it has done Integer.MAX_VALUE number of steps.
             */
        } while (curr_x != prev_x && steps < Integer.MAX_VALUE);

        System.out.println("|---------------------------------------------------|");

        /*
         * If the value is not the same as the sqrt computed by the
         * built-in sqrt method, then it's approximately equal to,
         * which is denoted by \u2248.
         */

        char sign = (curr_x == Math.sqrt(input)) ? '=' : '\u2248';
        System.out.println("The square root of " + input + " " + sign + " " + curr_x);
        System.out.println("This was done in " + steps + " steps");
    }
}