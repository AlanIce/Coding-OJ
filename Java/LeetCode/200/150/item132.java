public class Solution {
    public int minCut(String s) {
        char[] ch = s.toCharArray();
        int n = s.length();
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) dp[i] = i;
        for (int k = 1; k < n; k++) {
            helper(k, k, dp, ch);
            helper(k, k-1, dp, ch);
        }
        return dp[n-1];
    }

    void helper(int i, int j, int[] dp, char[] ch){
        while (j >= 0 && i < ch.length && ch[i] == ch[j]) {
            dp[i] = j > 0 ? Math.min(dp[i], dp[j-1] + 1) : 0;
            i++; j--;
        }
    }
}