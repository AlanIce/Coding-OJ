class Solution {
    private int m, n;
    public void solve(char[][] board) {
        if (board == null || board.length <=0 || board[0].length <= 0) return;
        n = board.length; m = board[0].length;
        for (int i = 0; i < m; i++) {
            flip(board, 0, i);
            flip(board, n - 1, i);
        }
        for (int i = 0; i < n; i++) {
            flip(board, i, 0);
            flip(board, i, m - 1);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0;j < m; j++){
                if (board[i][j]=='*')  board[i][j]='O';
                else board[i][j]='X';
            }
        }

    }
    public void flip(char[][] board,int i,int j){
        if(board[i][j]=='O'){
            board[i][j]='*';
            if (i > 1) flip(board,i-1,j);
            if(i < n - 2) flip(board,i+1,j);
            if(j > 1) flip(board,i,j-1);
            if(j < m - 2) flip(board,i,j+1);
        }
    }
}