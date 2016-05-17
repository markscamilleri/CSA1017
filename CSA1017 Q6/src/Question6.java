/**
 * @author Mark Said Camilleri
 * @version 20160517
 */
public class Question6 {

    /**
     * Stores the size of the matrices
     */
    public static final int SIZE = 32;

    public static void main(String[] args) {

        /*=========================== WELCOME USER ================================*/
        System.out.println("_____________________________________________________");
        System.out.println("|    CSA 1017 - Data Structures and Algorithms 1    |");
        System.out.println("|---------------------------------------------------|");
        System.out.println("|         Submission by Mark Said Camilleri         |");
        System.out.println("|           Task 6: Matrix Multiplication           |");
        System.out.println("|---------------------------------------------------|");

        /*
         * The 2 matricies. Matrix A will be multuplied with matrix B
         * to from matrix AB.
         */
        double[][] matrixA = new double[SIZE][SIZE];
        double[][] matrixB = new double[SIZE][SIZE];

        //Put random values from 1 to 10 in matrixA
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                matrixA[i][j] = Math.random() * 20 - 10;
            }
        }

        //Put random values from 1 to 10 in matrixB
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                matrixB[i][j] = Math.random() * 20 - 10;
            }
        }

        //Multiplied matrix
        double[][] result = new double[SIZE][SIZE];


       /*
        * Transposes MatrixB. This is done to make the multiplication
        * easier since the method would accept 2 arrays, one for the
        * row and the other for the column.
        */
        double[][] matBtranspose = matTranspose(matrixB);

       /*
        * Multiplies each row of Matrix A with each column of Matrix B
        * and adds them up to get the value of each cell.
        */

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                result[i][j] = cellMult(matrixA[i], matBtranspose[j]);
            }
        }
        //Outputs Matrix A
        System.out.print("Matrix A = ");
        displayMatrix(matrixA);


        System.out.println();
        System.out.print("Matrix B = ");
        displayMatrix(matrixB);

        System.out.println();
        System.out.print("  A * B =  ");
        displayMatrix(result);

    }

    /**
     * Performs a matrix multiplication for 1 cell only.
     *
     * @param row The row of the first matrix to be multiplied
     * @param col The colum of the second matrix to be multiplied
     * @return The value of the cell that resides in both the row and column that were inputted, for the resultant matrix.
     */
    public static double cellMult(double[] row, double[] col) {
        //Result to be returned when finished.
        double result = 0;

        for (int i = 0; i < SIZE; i++) {
            result += (row[i] * col[i]);
        }

        return result;
    }

    /**
     * Transposes a square matrix of n x n size
     *
     * @param matrix The matrix to be transposed
     * @return matrix transposed
     */
    public static double[][] matTranspose(double[][] matrix) {

        double[][] transposed = new double[matrix.length][matrix[0].length];

        for (int i = 0; i < transposed.length; i++) {
            for (int j = 0; j < transposed[0].length; j++) {
                transposed[i][j] = matrix[j][i];
            }
        }

        return transposed;
    }

    /**
     * Displays the matrix to the user.
     *
     * @param matrix The matrix to be displayed to the user.
     */
    public static void displayMatrix(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%7.2f ", matrix[i][j]);
            }
            System.out.println();
            System.out.print("           ");
        }
    }
}
