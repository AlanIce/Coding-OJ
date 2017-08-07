public class Solution {
    public int minPathSum(int[][] grid) {
        int width = grid[0].length;
        if (width == 0) return 0;
        int[] dp = new int[width];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < width; j++) {
                dp[j] = Math.min(j == 0 ? dp[j] : dp[j - 1], i == 0 ? Integer.MAX_VALUE : dp[j]) + grid[i][j];
            }
        }
        return dp[width - 1];
    }
}