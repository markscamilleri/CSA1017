import java.util.Arrays;

/**
 * @author Mark Said Camilleri
 * @version 20160516
 */
public class Question4 {

    public static final int SIZE = 16384;

    public static void main(String[] args) {

        /*======================== WELCOME MESSAGE TO USER =======================*/
        System.out.println("_____________________________________________________");
        System.out.println("|    CSA 1017 - Data Structures and Algorithms 1    |");
        System.out.println("|---------------------------------------------------|");
        System.out.println("|         Submission by Mark Said Camilleri         |");
        System.out.println("|          Task 4: Shell Sorting Algorithm          |");
        System.out.println("|---------------------------------------------------|");
        System.out.println("| The array to be sorted is:                        |");

        //The array, which  will eventially be sort
        int[] arr = new int[SIZE];

        //Populating the array with random data.
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * SIZE);
        }

        //Displays the unsorted array to the user.
        System.out.println("Unsorted Array: " + Arrays.toString(arr));

        //Sorts the array
        int[] sorted = shellSort(arr);

        //Displays the sorted array to the user
        System.out.println("Sorted Array:   " + Arrays.toString(sorted));

        //Displays whether the array is indeed sorted or not.
        System.out.println("Array is sorted: " + checkSortedAscending(sorted));
    }

    /**
     * Sorts the inputted array using the shell sort algorithm.
     *
     * @param unsorted The array to be sorted
     * @return The sorted version of the array
     */
    private static int[] shellSort(int[] unsorted) {

        /*
         * First, the program begins my making a deep copy of the
         * array to make sure the original one isn't affected.
         */
        int[] sorted = Arrays.copyOf(unsorted, SIZE);

        /*
         * This loop begins with the iterator being set at half the
         * size of the array, - 1. This then iterates downwards by
         * incrementing the iterator, dividing it by 2 and subtracting
         * 1 from it, until it performs it's final iteration at a
         * value of 1.
         */
        for (int sep = (unsorted.length / 2) - 1; sep > 0; sep = (sep + 1) / 2 - 1) {
            /*
             * This for loop goes through the items between sep and
             * the end of the array. To then use an bu sort
             * algorithm to switch it
             */
            for (int i = sep; i < SIZE; i++) {
                /*
                 * The algorthm begins by storing the value in a
                 * temporary variable.
                 */
                int temp = sorted[i];

                //iterator for next for loop. Used also outside loop.
                int j;
                /*
                 * Finds good position of temp in steps of sep, sort
                 * of like insertion sort.
                 */
                for (j = i; j >= sep && sorted[j - sep] > temp; j -= sep) {
                    /*
                     * Moves the (j-sep)th by a step of sep to
                     * leave space for temp at it's proper place.
                     */
                    sorted[j] = sorted[j - sep];
                }
                //Once found temp is stored in it's proper place.
                sorted[j] = temp;
            }
        }
        return sorted;

    }

    /**
     * Method that checks whether the elements in the array in the
     * parameter are all in ascending order.
     *
     * @param array The array to be checked.
     * @return true if all elements are in ascending order, false otherwise.
     */
    public static boolean checkSortedAscending(int[] array) {

         /* Iterates through all elements except for the last one.
         * If an unsorted element is found for loop stops.
         */
        for (int i = 0; i < array.length - 1; i++) {
            /*
             * If the ith element is larger than the i-1th element
             * then the array is not sorted. Method ends returning
             * false
             */
            if (array[i] > array[i + 1])
                return false;
        }
        /* If the condition is never satisfied, then the method returns
         * true.
         */
        return true;
    }
}
