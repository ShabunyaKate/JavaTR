package by.javatr.task3.service;

import by.javatr.task3.entity.Matrix;

import java.util.Arrays;

public class MatrixPresentation {
    /**@metod print Matrix in Console
     * @param matrix
     */
    public static void show(Matrix matrix) {
        int[] row = new int[matrix.getLength()];
        for (int i = 0; i < matrix.getLength(); ++i) {
            for (int j = 0; j < matrix.getLength(); ++j) {
                row[j] = matrix.getElement(i, j);
            }
            printRow(row);
        }
    }
    /** print row in console*/
    private static void printRow(int[] row) {
        for (int i : row) {
            System.out.print(i);
            System.out.print("\t");
        }
        System.out.println();
    }
    }


