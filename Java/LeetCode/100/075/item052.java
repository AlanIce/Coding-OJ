class Solution {
    public int totalNQueens(int n) {
        List<List<String>> result = new LinkedList<>();
        int[] queens = new int[n];
        return solveNQueens(queens, n, 0);
    }

    private int solveNQueens(int[] queens, int n, int index) {
        if (index == n) return 1;
        int count = 0;
        for (int i = 0; i < n; i++) {
            queens[index] = i;
            boolean vaild = true;
            for (int j = 0; j < index; j++)
                if (queens[j] == i || index - j == Math.abs(i - queens[j])) {
                    vaild = false;
                    break;
                }
            if (vaild) count += solveNQueens(queens, n, index + 1);
        }
        return count;
    }
}