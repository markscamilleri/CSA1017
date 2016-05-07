/**
 * Created by mark on 08/02/16.
 */


import java.util.InputMismatchException;
import java.util.Scanner;


public class Question1 {

    public static void main(String args[]) {

        //Initialize Scanner object
        Scanner in = new Scanner(System.in);
        in.useDelimiter("\n");

        /*======================== WELCOME MESSAGE TO USER =======================*/
        System.out.println("_____________________________________________________");
        System.out.println("|    CSA 1017 - Data Structures and Algorithms 1    |");
        System.out.println("|---------------------------------------------------|");
        System.out.println("|         Submission by Mark Said Camilleri         |");
        System.out.println("|     Task 1: Arabic to Roman Numeral Converter     |");
        System.out.println("|---------------------------------------------------|");
        System.out.print("| Please enter a number between 1 and 1024: ");


        int toConvert = 0; //value to be converted.
        boolean isError; // temporary boolean value used for error checking of the input.
        do {
            isError = false;
            try {
                toConvert = in.nextInt();
            } catch (InputMismatchException e) {
                isError = true;
                in.next(); //To clear the buffer
            }
            /*=========== Makes sure input is a number is between 1 and 1024 =============*/
            if (isError || toConvert < 1 || toConvert > 1024) {
                /*==================== OUTPUT ERROR MESSAGE TO THE USER ==================*/
                System.out.println("|---------------------------------------------------|");
                System.out.println("|The input was not a valid number between 1 and 1024|");
                System.out.print("|Please try again and enter a number to convert: ");
            }
        } while (isError || toConvert < 1 || toConvert > 1024);

        System.out.printf("| %4d = %-24s in Roman Numerals |", toConvert, convert(toConvert));

    }

    /**
     * Takes an int decimal value and outputs a string of the same value in Roman Numerals.
     *
     * @param toConvert the decimal value to ve converted to Roman Numerals
     * @return The roman numeral equivalent of the input parameter
     */
    private static String convert(int toConvert) {

        //Defining the decimal and roman counterparts
        final int dec[] = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        final String rom[] = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};

        /* Begins by checking the input paramerer against the largest roman numeral/numeral pair.
         * and works it's way down to the unit numeral.
         */
        for (int i = dec.length - 1; i >= 0; i--) {
            //If the value is larger, then the output is concatenated with the output of the difference.
            if (toConvert >= dec[i]) return rom[i] + convert(toConvert - dec[i]);
        }
        return ""; //What to return at 0, the base case.
    }
}