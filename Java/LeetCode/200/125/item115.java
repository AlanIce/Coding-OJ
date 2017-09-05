class Solution {
    public int numDistinct(String s, String t) {
        int S = s.length(), T = t.length();
        char[] sa = s.toCharArray(), ta = t.toCharArray();
        int[] dp = new int[S + 1];
        for (int i = 0; i <= S; i++) dp[i] = 1;
        for (int i = 1; i <= T; i++) {
            dp[0] = 0;
            int prev = i == 1 ? 1 : 0, cur = 0, temp = 0;
            for (int j = 1; j <= S; j++) {
                temp = dp[j];
                if (ta[i - 1] == sa[j - 1])
                    dp[j] = prev + cur;
                else
                    dp[j] = cur;
                prev = temp;
                cur = dp[j];
            }
        }
        return dp[S];
    }
}