import java.math.BigDecimal;
import java.util.Scanner;
import java.util.jar.Attributes;

/**
 * Created by mark on 25/04/16.
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
        Scanner in = new Scanner(System.in);

        String exp = "\0";

        /*===================== CHECK IF INPUT IS CORRECT ========================*/
        boolean isWrong = false;
        do{
            isWrong = false;
            exp = in.nextLine();

            if(exp.charAt(0) != 's' && exp.charAt(0) != 'c'){
                isWrong = true;
                System.out.println("| Please enter the input with the function character|");
            }
            else if(exp.charAt(exp.length()-1) != 'd' && exp.charAt(exp.length()-1) != 'r'){
                isWrong = true;
                System.out.println("| Please enter the input with the unit character    |");
            }
        }
        while(isWrong);

        /*====================== PARSE USER INPUT ================================*/

        char fn = exp.charAt(0);  //First character determines which function to evaluate
        char units = exp.charAt(exp.length()-1); //Last character determines the units

        double angle;
        //Multiplies the value by pi if "pi" is inputted.
        if(exp.contains("pi")){
            angle = ((exp.length()== 4)?1:Double.valueOf(exp.substring(1,exp.length()-3))) * Math.PI;
        }else angle = Double.valueOf(exp.substring(1,exp.length()-1));

        //Converts to radians since Mclaurins is in radians
        if(units == 'd')angle = Math.toRadians(angle);

        //Reduces the angle to between -pi and pi.
        angle %= (2* Math.PI);

        /*=============== ASK USER HOW MANY TERMS TO EVALUATE ====================*/
        System.out.println("|    Please enter the number of terms to evaluate   |");
        System.out.println("|    the approximation of the expression inserted   |");

        int n = in.nextInt();

        double result = (fn == 's')?sine(angle,n):cosine(angle,n);

        System.out.printf("| The answer is: %-34f |", result);
    }

    public static double sine(double angle, int terms){
        double result = 0;
        for (int n = 0; n <= terms; n++) {
            result += (Math.pow(-1,n)*Math.pow(angle,2*n + 1))/fact(2*n +1);
        }
        return result;
    }

    public static double cosine(double angle, int terms){
        double result = 0;
        for (int n = 0; n <= terms; n++) {
            result += (Math.pow(-1,n)*Math.pow(angle,2*n))/fact(2*n);
        }
        return result;
    }


    private static double fact(double n){
        double result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
