/**
 * Created by mark on 18/02/16.
 */
public class Question6 {
    
    public static final int SIZE = 32;
    
    public static void main(String[] args) {

        System.out.println("_____________________________________________________");
        System.out.println("|    CSA 1017 - Data Structures and Algorithms 1    |");
        System.out.println("|---------------------------------------------------|");
        System.out.println("|         Submission by Mark Said Camilleri         |");
        System.out.println("|           Task 6: Matrix Multiplication           |");
        System.out.println("|---------------------------------------------------|");
        
        double[][] matrixA = new double[SIZE][SIZE];
        double[][] matrixB = new double[SIZE][SIZE];


        //Put random values from 1 to 10 in matrixA
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                matrixA[i][j] = Math.random() * 10 + 1;
            }
        }

        //Put random values from 1 to 10 in matrixB
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                matrixB[i][j] = Math.random() * 10 + 1;
            }
        }

        //Multiplied matrix
        double[][] result = new double[SIZE][SIZE];


        //Transpose MatrixB
        double[][] matBtranspose = matTranspose(matrixB);

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                result[i][j] = cellMult(matrixA[i], matBtranspose[j]);
            }
        }

        System.out.print("Matrix A = ");
        for (int i = 0; i < SIZE; i++) {

            for (int j = 0; j < SIZE; j++) {
                System.out.printf("%5.2f ",matrixA[i][j]);
            }
            System.out.println();
            System.out.print("           ");

        }
        System.out.println();
        System.out.print("Matrix B = ");
        for (int i = 0; i < SIZE; i++) {

            for (int j = 0; j < SIZE; j++) {
                System.out.printf("%5.2f ",matrixB[i][j]);
            }
            System.out.println();
            System.out.print("           ");

        }

        System.out.println();
        System.out.print("  A * B =  ");
        for (int i = 0; i < SIZE; i++) {

            for (int j = 0; j < SIZE; j++) {
                System.out.printf("%7.2f ",result[i][j]);
            }
            System.out.println();
            System.out.print("           ");

        }


    }

    /**
     * Performs a matrix multiplication for 1 cell only.
     * @param row The row of the first matrix to be multiplied
     * @param col The colum of the second matrix to be multiplied
     * @return The value of the cell that resides in both the row and column that were inputted, for the resultant matrix.
     */
    static double cellMult(double[] row, double[] col){
        double result = 0;

        for (int i = 0; i < SIZE; i++) {
            result += (row[i] * col[i]);
        }

        return result;
    }

    /**
     * Transposes a square matrix of n x n size
     * @param matrix The matrix to be transposed
     * @return matrix transposed
     */
    static double[][] matTranspose(double[][] matrix){

        double[][] transposed = new double[matrix.length][matrix[0].length];

        for (int i = 0; i < transposed.length; i++) {
            for (int j = 0; j < transposed[0].length; j++) {
                transposed[i][j] = matrix[j][i];
            }
        }

        return transposed;
    }
}
