import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Mark Said Camilleri
 * @version 20160523
 */
public class Question8 {
    public static void main(String[] args) {
        System.out.println("_____________________________________________________");
        System.out.println("|    CSA 1017 - Data Structures and Algorithms 1    |");
        System.out.println("|---------------------------------------------------|");
        System.out.println("|         Submission by Mark Said Camilleri         |");
        System.out.println("|        Task 8: Sine or Cosine Approximation       |");
        System.out.println("|---------------------------------------------------|");

        /*================= ASK USER FOR EXPRESSION INPUT ========================*/
        System.out.println("| Please enter \'s\' or \'c\' to compute the sine or    |");
        System.out.println("| cosine function respectively, followed by the     |");
        System.out.println("| value to compute it on. Use \"pi\" for pi. This     |");
        System.out.println("| should be followed by \'r\' or \'d\' for radians or   |");
        System.out.println("| or degrees respectively.                          |");
        System.out.println("|---------------------------------------------------|");
        System.out.println("| For example, sin(2pi radians) is entered as s2pir |");
        System.out.println("|      or cos(180 degrees) is entered as c180d      |");
        System.out.println("|---------------------------------------------------|");

        /*====================== ACCEPT EXPRESSION INPUT =========================*/
        Scanner in = new Scanner(System.in).useDelimiter("\n");

        String exp = ""; //Default expression is empty string.

        /*===================== CHECK IF INPUT IS CORRECT ========================*/
        boolean isWrong; //Used to ask user to input again
        do {
            isWrong = false; //Assumes input will be correct.
            exp = in.nextLine(); //Takes user input

            //Incorrect input if first character is not c or s (function)
            if (exp.charAt(0) != 's' && exp.charAt(0) != 'c') {
                isWrong = true;
                System.out.println("| Please enter the input with the function character|");
                //Incorrect input if last character is not d or r (unit)
            } else if (exp.charAt(exp.length() - 1) != 'd' && exp.charAt(exp.length() - 1) != 'r') {
                isWrong = true;
                System.out.println("| Please enter the input with the unit character    |");
            } else {
                try {
                    /*====================== PARSE USER INPUT ================================*/
                    /* First character determines which function to
                     * evaluate
                     */
                    char fn = exp.charAt(0);

                    //Last character determines the units
                    char units = exp.charAt(exp.length() - 1);

                    double angle; //Where angle is stored
                    //Multiplies the value by pi if "pi" is inputted.
                    if (exp.contains("pi")) {
                        //If a number isn't present, then it's 1*PI
                        //Throws a NumberFormatException
                        angle = ((exp.length() == 4) ? 1 : Double.valueOf(exp.substring(1, exp.length() - 3))) * Math.PI;
                    } else {
                        //Throws a NumberFormatException
                        angle = Double.valueOf(exp.substring(1, exp.length() - 1));
                    }

                    /*
                     * Converts to radians since Maclaurin's expansion
                     * works for radians
                     */
                    if (units == 'd') angle = Math.toRadians(angle);

                    /* Reduces the angle to between -2pi and 2pi. This
                     * makes it easier to compute. Sine and Cos are
                     * periodic functions.
                     */
                    angle %= (2 * Math.PI);

                    /*=============== ASK USER HOW MANY TERMS TO EVALUATE ====================*/
                    System.out.println("|    Please enter the number of terms to evaluate   |");
                    System.out.println("|    the approximation of the expression inserted   |");

                    //Number of terms to be evaluated for the series
                    int n = in.nextInt();

                    //Sine and Cosine are local methods
                    double result = (fn == 's') ? sine(angle, n) : cosine(angle, n);

                    System.out.printf("| The answer is: %-34f |\n", result);

                /* Catches an Exception if the input is not in the
                 * correct form.
                 */
                } catch (NumberFormatException | InputMismatchException except) {
                    System.out.println("| Your input could not be read. Please start over    |");
                    System.out.println("|           and input the expression again           |");

                    in.nextLine();

                    isWrong = true;
                }
            }
        } while (isWrong);
    }

    /**
     * Approximates the sine using Maclaurin's series expansion
     *
     * @param angle Angle in radians to calculate sin for
     * @param terms Number of terms to calculate
     * @return An approximation to sin(angle)
     */
    public static double sine(double angle, int terms) {
        double result = 0;
        //Adds the nth term to result
        for (int n = 0; n <= terms; n++) {
            result += (Math.pow(-1, n) * Math.pow(angle, 2 * n + 1)) / fact(2 * n + 1);
        }
        return result;
    }

    /**
     * Approximates the cosine using Maclaurin's series expansion
     * @param angle Angle in radians to calculate cos for
     * @param terms Number of terms to calculate
     * @return An approximation to cos(angle)
     */
    public static double cosine(double angle, int terms) {
        double result = 0;
        //Adds the nth term to result
        for (int n = 0; n <= terms; n++) {
            result += (Math.pow(-1, n) * Math.pow(angle, 2 * n)) / fact(2 * n);
        }
        return result;
    }

    /**
     * Caluclates the factorial of n
     * @param n number to calculate the factorial of
     * @return n!
     */
    private static double fact(double n) {
        //If n = 0 or 1, n! defaults to 1
        double result = 1;
        //Otherwise i is multiplied to result until n is reached.
        for (int i = 2; i <= n; i++) {
            result *= i;
        }

        return result;
    }
}
