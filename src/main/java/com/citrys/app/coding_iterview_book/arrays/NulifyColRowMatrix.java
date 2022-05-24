package com.citrys.app.coding_iterview_book.arrays;

public class NulifyColRowMatrix {
    public void nullyFyMatrix(int[][] matrix) {
        boolean[] row_zeros = new boolean[matrix.length];
        boolean[] col_zeros = new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length; i ++) {
            for (int j = 0; j < matrix[0].length; j ++) {
                if (matrix[i][j] == 0) {
                    row_zeros[i] = true;
                    col_zeros[j] = true;
                }
            }
        }

        for (int i = 0; i < row_zeros.length; i ++ ) {
            if (row_zeros[i]) {
                nullyfyRow(matrix, i);
            }
        }

        for (int i = 0; i < col_zeros.length; i ++ ) {
            if (col_zeros[i]) {
                nullyfyCol(matrix, i);
            }
        }
    }

    private void nullyfyCol(int[][] matrix, int col) {
        for (int i = 0; i < matrix.length; i ++ ) {
            matrix[i][col] = 0;
        }
    }

    private void nullyfyRow(int[][] matrix, int row) {
        for (int i = 0; i < matrix[0].length; i ++ ) {
            matrix[row][i] = 0;
        }
    }
}
