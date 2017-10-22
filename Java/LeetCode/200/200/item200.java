class Solution {
    private int row;
    private int col;

    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;
        int count = 0;
        row = grid.length;
        col = grid[0].length;
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++)
                if (grid[i][j] == '1') {
                    count++;
                    DFSMarking(grid, i, j);
                }
        return count;
    }

    private void DFSMarking(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= row || j >= col || grid[i][j] != '1') return;
        grid[i][j] = '#';
        DFSMarking(grid, i + 1, j);
        DFSMarking(grid, i - 1, j);
        DFSMarking(grid, i, j + 1);
        DFSMarking(grid, i, j - 1);
    }
}