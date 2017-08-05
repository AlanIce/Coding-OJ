public class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] use1 = new boolean[9][9], use2 = new boolean[9][9], use3 = new boolean[9][9];
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++) 
                if (board[i][j] != '.') {
                    int block = i / 3 * 3 + j / 3;
                    int num = board[i][j] - '1';
                    if (use1[i][num] || use2[j][num] || use3[block][num]) return false;
                    use1[i][num] = use2[j][num] = use3[block][num] = true;
                }
        return true;
    }
}