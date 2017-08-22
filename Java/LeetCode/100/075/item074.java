class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int row = matrix.length, col = matrix[0].length;
        if (row == 0 || col == 0) return false;
        int currow = 0, curcol = 0;
        while (currow + 1 < row && matrix[currow + 1][0] <= target) currow++;
        while (curcol + 1 < col && matrix[currow][curcol] < target) curcol++;
        System.out.println(currow + " : " + curcol);
        return matrix[currow][curcol] == target;
    }
}