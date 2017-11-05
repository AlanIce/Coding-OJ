class Solution {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) return;
        int row = board.length, col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int lives = getLiveCount(board, i, j, row, col);
                if (board[i][j] == 1 && lives >= 2 && lives <= 3) 
                    board[i][j] = 3; // Make the 2nd bit 1: 01 ---> 11
                if (board[i][j] == 0 && lives == 3) 
                    board[i][j] = 2; // Make the 2nd bit 1: 00 ---> 10
            }
        }
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++)
                board[i][j] >>= 1;
    }

    private int getLiveCount(int[][] board, int x, int y, int row, int col) {
        int count = 0;
        for (int i = Math.max(x - 1, 0); i <= Math.min(x + 1, row - 1); i++)
            for (int j = Math.max(y - 1, 0); j <= Math.min(y + 1, col - 1); j++)
                count += board[i][j] & 1;
        count -= board[x][y] & 1;
        return count;
    }
}