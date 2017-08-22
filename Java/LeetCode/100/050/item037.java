class Solution {

    boolean[][] use1 = new boolean[9][9];
    boolean[][] use2 = new boolean[9][9];
    boolean[][] use3 = new boolean[9][9];

    public void solveSudoku(char[][] board) {
        initalize(board);
        solve(board);
    }

    private void initalize(char[][] board) {
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                if (board[i][j] != '.') {
                    int block = i / 3 * 3 + j / 3;
                    int num = board[i][j] - '1';
                    use1[i][num] = use2[j][num] = use3[block][num] = true;
                }
    }

    private boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                if (board[i][j] == '.') {
                    for (int k = 0; k < 9; k++) {
                        int block = i / 3 * 3 + j / 3;
                        if (!use1[i][k] && !use2[j][k] && !use3[block][k]) {
                            board[i][j] = (char) (k + '1');
                            use1[i][k] = use2[j][k] = use3[block][k] = true;
                            if (solve(board)) return true;
                            board[i][j] = '.';
                            use1[i][k] = use2[j][k] = use3[block][k] = false;
                        }
                    }
                    return false;
                }
        return true;
    }
}