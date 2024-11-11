import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    /**
     * Get matrix int [ ] [ ].
     *
     * @param row    the row
     * @param column the column
     * @return the int [ ] [ ]
     */
    public static int[][] getMatrix(int row, int column){
        int[][] matrix = new int[row][column];
        System.out.printf("Enter "+row*column+" values of the matrix row by row: eg 2 3 4 go to the next line and enter values for the next row Note: any extra score will not be considered: \n", row, column);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = validation();
            }
        }
        return matrix;
    }

    /**
     * Validation int.
     * Check to make sure the input value is an integer
     * @return the int
     */
    public static int validation(){
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input (Should be an integer)!, Just enter the value of the incorrect one: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    /**
     * Find peak column string.
     *
     * @param matrix        the matrix
     * @param matrix_row    the matrix row
     * @param matrix_column the matrix column
     */
    public static void findPeakColumn(int[][] matrix, int matrix_row, int matrix_column) {
        for (int row = 0; row < matrix_row; row++) {
            // Find the maximum value in the current row (handling possible ties)
            int maxInRow = matrix[row][0];
            for (int col = 1; col < matrix_column; col++) {
                if (matrix[row][col] > maxInRow) {
                    maxInRow = matrix[row][col];
                }
            }

            //check each occurrence of maxInRow in the row
            for (int col = 0; col < matrix_column; col++) {
                if (matrix[row][col] == maxInRow) {
                    // Check if the value is the minimum in its column
                    boolean isMinInColumn = true;
                    for (int checkRow = 0; checkRow < matrix_row; checkRow++) {
                        if (matrix[checkRow][col] < maxInRow) {
                            isMinInColumn = false;
                            break;
                        }
                    }

                    // If it's both the max in its row and the min in its column, it's a peak-column
                    if (isMinInColumn) {
                        System.out.printf("A (%d,%d) = %d\n", row + 1, col + 1, maxInRow);
                    }


                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter the number of rows and number of columns of the matrix respectively eg 2 3: ");
        int matrix_row = validation();
        int matrix_column = validation();

        int[][] matrix = getMatrix(matrix_row, matrix_column);

        findPeakColumn(matrix, matrix_row, matrix_column);
    }
}