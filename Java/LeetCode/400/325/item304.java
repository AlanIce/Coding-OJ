class NumMatrix {
    private int[][] matrix;
    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        int row = matrix.length, col = matrix[0].length;
        for (int i = 0; i < row; i++)
            for (int j = 1; j < col; j++)
                matrix[i][j] += matrix[i][j - 1];
        for (int j = 0; j < col; j++)
            for (int i = 1; i < row; i++)
                matrix[i][j] += matrix[i - 1][j];
        this.matrix = matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1--; col1--;
        return getMatrix(matrix, row2, col2) + getMatrix(matrix, row1, col1)
                - getMatrix(matrix, row1, col2) - getMatrix(matrix, row2, col1);
    }

    private static final int  getMatrix(int[][] matrix, int i, int j) {
        if (i == -1 || j == -1) return 0;
        return matrix[i][j];
    }
}