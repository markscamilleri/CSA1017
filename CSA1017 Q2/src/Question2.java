import java.util.Scanner;

/**
 * Created by mark on 09/02/16.
 */
public class Question2 {

    public static void main(String args[]) {

        //Initialize Scanner object
        Scanner in = new Scanner(System.in).useDelimiter("\n");

        System.out.println("_____________________________________________________");
        System.out.println("|    CSA 1017 - Data Structures and Algorithms 1    |");
        System.out.println("|---------------------------------------------------|");
        System.out.println("|         Submission by Mark Said Camilleri         |");
        System.out.println("|     Task 2: Reverse Polish Notation evaluator     |");
        System.out.println("|---------------------------------------------------|");
        System.out.print("| Please enter a number to convert: ");

        Stack<Double> nums = new Stack<>();

        String expression = in.next();
        System.out.println("|---------------------------------------------------|");
        System.out.println("| Contents of the stack at each step:               |");

        for (int i = 0; i < expression.length(); i++) {
            char cChar = expression.charAt(i);

            if (Character.isWhitespace(cChar)) continue;
            else if (cChar == '+') {
                double num1 = nums.pop();
                double num2 = nums.pop();

                nums.push(num2 + num1);
            } else if (cChar == '-') {
                double num1 = nums.pop();
                double num2 = nums.pop();

                nums.push(num2 - num1);
            } else if (cChar == '*') {
                double num1 = nums.pop();
                double num2 = nums.pop();

                nums.push(num2 * num1);
            } else if (cChar == '/') {
                double num1 = nums.pop();
                double num2 = nums.pop();

                nums.push(num2 / num1);
            } else {
                int start = i;
                while (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.') i++;

                nums.push(Double.parseDouble(expression.substring(start, i)));
            }
            System.out.printf("| %-49s |\n", nums.toString());
        }
        System.out.println("|---------------------------------------------------|");
        System.out.printf("| Answer of Evaluation = %-26s |\n", nums.pop().toString());
        System.out.println("|___________________________________________________2|");

    }
}
