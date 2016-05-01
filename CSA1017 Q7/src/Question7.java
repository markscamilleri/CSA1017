import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by mark on 14/04/16.
 */
public class Question7 {
    public static void main(String[] args) {

        System.out.println("_____________________________________________________");
        System.out.println("|    CSA 1017 - Data Structures and Algorithms 1    |");
        System.out.println("|---------------------------------------------------|");
        System.out.println("|         Submission by Mark Said Camilleri         |");
        System.out.println("|               Task 7: Largest Number              |");
        System.out.println("|---------------------------------------------------|");

        Scanner in = new Scanner(System.in);

        String[] text_nos;
        int[] numbers = {0};

        boolean inputIsCorrect;
        do {
            try {
                inputIsCorrect = true;

                System.out.println("| Please enter a list of numbers. Seperate each one |");
                System.out.println("| with a space. Press Enter at the end of the list: |");

                text_nos = in.nextLine().split("\\s");

                numbers = new int[text_nos.length];

                for (int i = 0; i < text_nos.length; i++) {
                    numbers[i] = Integer.parseInt(text_nos[i]);
                }
            } catch (NumberFormatException nme) {
                inputIsCorrect = false;

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

    public static int findMax(int[] nums, int max) {
        if (nums.length == 0) {
            return max;
        } else {
            if (nums[0] > max) {
                max = nums[0];
            }
            return findMax(Arrays.copyOfRange(nums, 1, nums.length), max);

        }
    }
}
