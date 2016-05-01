import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by mark on 14/02/16.
 */
public class Question4 {

    public static final int SIZE = 16384;

    public static void main(String[] args) {

        System.out.println("_____________________________________________________");
        System.out.println("|    CSA 1017 - Data Structures and Algorithms 1    |");
        System.out.println("|---------------------------------------------------|");
        System.out.println("|         Submission by Mark Said Camilleri         |");
        System.out.println("|          Task 4: Shell Sorting Algorithm          |");
        System.out.println("|---------------------------------------------------|");
        System.out.println("| The array to be sorted is:                        |");

        int[] arr = new int[SIZE];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((Math.random() + 1) * SIZE);
        }

        int[] sorted = shellSort(arr);
        System.out.print("Unsorted Array: ");
        System.out.println(Arrays.toString(arr));

        System.out.print("Sorted Array: ");
        System.out.println(Arrays.toString(sorted));

    }

    private static int[] shellSort(int[] unsorted) {
        int[] sorted = Arrays.copyOf(unsorted, SIZE);

        for (int sep = ((int) Math.pow(2, Math.log(SIZE) / Math.log(2)-1) - 1); sep > 0; sep= (sep+1)/2-1){
             for (int i = sep; i < SIZE; i++) {
                int temp = sorted[i];

                int j;
                 //Finds position of temp
                for(j = i; j >= sep && sorted[j-sep] > temp;  j -=  sep){
                    //swap
                    sorted[j] = sorted[j - sep];
                }
                sorted[j] = temp;
            }
        }
        return sorted;

    }
}
