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

        System.out.println("_____________________________________________________");
        System.out.println("|    CSA 1017 - Data Structures and Algorithms 1    |");
        System.out.println("|---------------------------------------------------|");
        System.out.println("|         Submission by Mark Said Camilleri         |");
        System.out.println("|     Task 1: Arabic to Roman Numeral Converter     |");
        System.out.println("|---------------------------------------------------|");
        System.out.print("| Please enter a number to convert: ");


        int toConvert = 0;
        boolean isError;
        do {
            isError = false;
            try {
                toConvert = in.nextInt();
            } catch (InputMismatchException e) {
                isError = true;
                System.out.println("|---------------------------------------------------|");
                System.out.println("|The input was not a valid number between 1 and 1024|");
                System.out.printf("| %-49s |\n", e);
                System.out.print("| Please try again and enter a number to convert: ");
                in.next(); //To clear the buffer
            }
            if (!isError && (toConvert < 1 || toConvert > 1024)) {
                System.out.println("|The input was not a valid number between 1 and 1024|");
                System.out.print("|Please try again and enter a number to convert: ");
            }
        } while (isError || toConvert < 1 || toConvert > 1024);

        System.out.printf("| %4d = %-24s in Roman Numerals |", toConvert, convert(toConvert));

    }

    private static String convert(int toConvert) {

        //Defining the decimal and roman counterparts
        int dec[] = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String rom[] = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};

        int i = dec.length - 1;
        for (i = dec.length - 1; i >= 0; i--) {
            if (toConvert >= dec[i]) return rom[i] + convert(toConvert - dec[i]);
        }
        return ""; //What to return at 0, the base case.
    }
}