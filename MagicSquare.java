import java.io.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Daylen Mathews
 *         CS221 Magic Squares Warmup assignment
 *         The Magic Square implements a MagicSquareInterface. This allows each
 *         user to create a matrix
 *         with the dimensions that the user wants. It also allows for columns,
 *         rows, and diagonals to be added together.
 *
 */

// Create 2D array to hold matrix
public class MagicSquare implements MagicSquareInterface {
    private final int[][] matrixMagicSquare;
    //private final boolean isValidMagicSquare;

    // Constructor that read Magic Square from file
    public MagicSquare(String fileName) throws FileNotFoundException {
        matrixMagicSquare = readMatrix(fileName);
        //isValidMagicSquare = isMagicSquare();
    }

    public MagicSquare(String filename, int dimension) {
        if (dimension % 2 == 0) {
            // Ensure dimension is odd
            throw new IllegalArgumentException("Dimension must be an odd positive integer.");
        }
        matrixMagicSquare = new int[dimension][dimension];
        generateMagicSquare(dimension);
        //isValidMagicSquare = isMagicSquare();
    }

    private int[][] readMatrix(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        int size = Integer.parseInt(scanner.nextLine().trim());
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (scanner.hasNextInt()) {
                    matrix[i][j] = scanner.nextInt();
                } else {
                    scanner.close();
                    throw new FileNotFoundException("Invalid matrix data in file.");
                }
            }
        }
        scanner.close();
        return matrix;
    }

    public void saveToFile(String fileName) throws IOException {
        File file = new File(fileName);
        PrintWriter outFile = new PrintWriter(new FileWriter(file));

        outFile.println();
    }


    public void generateMagicSquare(int size) {
        int n = size;
        int row = n - 1;
        int col = n / 2;

        for (int i = 1; i <= n * n; i++) {
            matrixMagicSquare[row][col] = i;
            int oldRow = row;
            int oldCol = col;
            row++;
            col++;
            if (row == n)
                row = 0;
            if (col == n)
                col = 0;
            if (matrixMagicSquare[row][col] != 0) {
                row = oldRow - 1;
                col = oldCol;
            }
        }
    }

    /**
     * Checks if the matrix is a valid square
     *
     * @return true if the matrix is a valid square, the square is false otherwise
     */
    public boolean isMagicSquare() {
        int n = matrixMagicSquare.length;
        int magicNumber = n * (n * n + 1) / 2;

        for (int i = 0; i < n; i++) {
            int rowSum = 0;
            int colSum = 0;
            for (int j = 0; j < n; j++) {
                rowSum += matrixMagicSquare[i][j];
                colSum += matrixMagicSquare[j][i];
            }
            if (rowSum != magicNumber || colSum != magicNumber) {
                return false;
            }
        }
        /**
         * Checks the sums of the diagonals
         */
        int diagonal1 = 0, diagonal2 = 0;
        for (int i = 0; i < n; i++) {
            diagonal1 += matrixMagicSquare[i][i];
            diagonal2 += matrixMagicSquare[i][n - 1 - i];
        }
        if (diagonal1 != magicNumber || diagonal2 != magicNumber) {
            return false;
        }

        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int[] row : matrixMagicSquare) {
            for (int elem : row) {
                uniqueNumbers.add(elem);
            }
        }
        for (int i = 1; i <= n * n; i++) {
            if (!uniqueNumbers.contains(i)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Retrieves the matrix in the magic square
     * 
     * @return the matrixMagicSquare
     */
    public int[][] getMatrix() {
        return matrixMagicSquare;
    }

    /**
     * Retrieves the size of the matrix in the magic square
     * 
     * @return the size of the matrix
     */
    public int getSize() {
        return matrixMagicSquare.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int[] row : matrixMagicSquare) {
            for (int elem : row) {
                sb.append(elem).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
