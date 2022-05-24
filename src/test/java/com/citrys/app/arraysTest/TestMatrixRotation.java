package com.citrys.app.arraysTest;

import com.citrys.app.coding_iterview_book.arrays.NulifyColRowMatrix;
import com.citrys.app.coding_iterview_book.arrays.RotateMatrix90;
import org.junit.Test;

public class TestMatrixRotation {
    @Test
    public void matrixRotation() {
        RotateMatrix90 test = new RotateMatrix90();
        int[][] matrix = { { 1, 2, 3, 4 },
                         { 5, 6, 7, 8 },
                         { 9, 10, 11, 12 },
                         { 13, 14, 15, 16 } };
        test.rotateTheMatrix(matrix);
        printMatrix(matrix);
    }

    @Test
    public void matrixZerofy() {
        NulifyColRowMatrix test = new NulifyColRowMatrix();
        int[][] matrix = { { 1, 0, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        test.nullyFyMatrix(matrix);
        printMatrix(matrix);
    }


    static void printMatrix(int arr[][])

    {
        int N = arr.length;
        for (int[] ints : arr) {
            for (int j = 0; j < N; j++)
                System.out.print(ints[j] + " ");
            System.out.println();
        }
    }
}
