class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int m = i;
            for (int j = 1; j * j <= i; j++) 
                m = Math.min(m, dp[i - j * j]);
            dp[i] = m + 1;
        }
        return dp[n];
    }
}