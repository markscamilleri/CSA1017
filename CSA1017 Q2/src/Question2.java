import java.util.Scanner;

/**
 * Created by mark on 09/02/16.
 * This answer assumes the RPN input is correct.
 */
public class Question2 {
    public static void main(String args[]) {

        //Initialize Scanner object
        Scanner in = new Scanner(System.in).useDelimiter("\n");

        /*======================== WELCOME MESSAGE TO USER =======================*/
        System.out.println("_____________________________________________________");
        System.out.println("|    CSA 1017 - Data Structures and Algorithms 1    |");
        System.out.println("|---------------------------------------------------|");
        System.out.println("|         Submission by Mark Said Camilleri         |");
        System.out.println("|     Task 2: Reverse Polish Notation evaluator     |");
        System.out.println("|---------------------------------------------------|");
        System.out.print("| Please enter a number to convert: "); //prompt for user input. Assumes correctness.

        //Initialized a stack object (using the stack defined here). Note, no importing of the Stack class.
        Stack<Double> nums = new Stack<>();

        //Reads user input. Must be a valid RPN expression.
        String expression = in.next();
        System.out.println("|---------------------------------------------------|");
        System.out.println("| Contents of the stack at each step:               |");//some message to user.

        //Iterates through the string inputted by the user.
        for (int i = 0; i < expression.length(); i++) {
            char cChar = expression.charAt(i);

            //If the current character is a space, nothing needs to be done.
            if (Character.isWhitespace(cChar)) continue;
                //If it's a '+', then 2 numbers are popped, added and the answer is pushed onto the stack.
            else if (cChar == '+') {
                double num1 = nums.pop();
                double num2 = nums.pop();

                nums.push(num2 + num1);
            }
            //If it's a '-', then 2 numbers are popped, subtracted and the answer is pushed onto the stack.
            else if (cChar == '-') {
                double num1 = nums.pop();
                double num2 = nums.pop();

                nums.push(num2 - num1);
            }
            //If it's a '*', then 2 numbers are popped, multiplied and the answer is pushed onto the stack.
            else if (cChar == '*') {
                double num1 = nums.pop();
                double num2 = nums.pop();

                nums.push(num2 * num1);
            }
            //If it's a '/', then 2 numbers are popped, divided and the answer is pushed onto the stack.
            else if (cChar == '/') {
                double num1 = nums.pop();
                double num2 = nums.pop();

                nums.push(num2 / num1);
            }
            /*
             * Otherwise, assuming it's inputted correctly, the character must be a number.
             * In which case it is converted ot a double (allowing for any real number to be inputted)
             * and pushed onto the stack.
             */
            else {
                int start = i;
                while (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.') i++;

                nums.push(Double.parseDouble(expression.substring(start, i)));
            }
            System.out.printf("| %-49s |\n", nums.toString());
        }

        //When the above iteration is complete, there should only be one item on the stack whcih is the answer.
        System.out.println("|---------------------------------------------------|");
        System.out.printf("| Answer of Evaluation = %-26s |\n", nums.pop().toString());
        System.out.println("|___________________________________________________|");
    }
}
