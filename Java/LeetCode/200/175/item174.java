class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        final int row = dungeon.length;
        final int col = dungeon[0].length;
        int[] dp = new int[col + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[col - 1] = 1;
        for (int i = row - 1; i >= 0; i--)
            for (int j = col - 1; j >= 0; j--) {
                dp[j] = getMin(Math.min(dp[j], dp[j + 1]) - dungeon[i][j]);
            }
        return dp[0];
    }

    private static final int getMin(int n) {
        return n <= 0 ? 1 : n;
    }
}