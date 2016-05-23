import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Mark Said Camilleri
 * @version 20160517
 */
public class Question7 {
    public static void main(String[] args) {

        /*=========================== WELCOME USER ================================*/
        System.out.println("_____________________________________________________");
        System.out.println("|    CSA 1017 - Data Structures and Algorithms 1    |");
        System.out.println("|---------------------------------------------------|");
        System.out.println("|         Submission by Mark Said Camilleri         |");
        System.out.println("|               Task 7: Largest Number              |");
        System.out.println("|---------------------------------------------------|");

        Scanner in = new Scanner(System.in);

        //This will store the numbers before formatted as numbers.
        String[] text_nos;
        int[] numbers = {0};

        /* This is to ask the user to input the numbers again if the
         * user has provided us with a bad input.
         */
        boolean inputIsCorrect;
        do {
            try {
                inputIsCorrect = true;

                //Ask user for input.
                System.out.println("| Please enter a list of integers. Seperate them    |");
                System.out.println("| with a space. Press Enter at the end of the list: |");

                //Reads input and splits it to string array.
                text_nos = in.nextLine().split("\\s");

                //Creates int array to store them.
                numbers = new int[text_nos.length];

                //Parses the strings in the string array to integers.
                for (int i = 0; i < text_nos.length; i++) {
                    numbers[i] = Integer.parseInt(text_nos[i]);
                }
            } catch (NumberFormatException nme) {

                //Flags program to ask again for input.
                inputIsCorrect = false;

                //Tells user there was an error
                System.out.println("|---------------------------------------------------|");
                System.out.println("|    There was an error processing your input.      |");
                System.out.println("|                 Please try again.                 |");
                System.out.println("|---------------------------------------------------|");
            }
        } while (!inputIsCorrect);

        System.out.println("|===================================================|");
        System.out.printf("| The maximum number from your list was: %10d |\n", findMax(numbers, Integer.MIN_VALUE));
        System.out.println("|===================================================|");
    }

    /**
     * Recursive function to find the maximum number in an array
     *
     * @param nums The array to return it's max value
     * @param max  Current maximum value. This should start with
     *             Integer.MIN_VALUE.
     * @return the maximum value.
     */
    public static int findMax(int[] nums, int max) {

        //Base case. If array is empty.
        if (nums.length == 0) {
            return max;
        } else {

            /* If the element at startIndex > max, then it is the
             * current maximum value.
             */
            if (nums[0] > max) {
                max = nums[0];
            }

            /* Recursive call. Checks this max with the array starting
             * from the next element
             */
            return findMax(Arrays.copyOfRange(nums, 1, nums.length), max);

        }
    }
}
