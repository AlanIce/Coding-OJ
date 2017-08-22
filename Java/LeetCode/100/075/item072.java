class Solution {
    public int minDistance(String word1, String word2) {
        if (word1.length() > word2.length()) return minDistance(word2, word1);
        int length = word1.length(), length2 = word2.length();
        int[] dp = new int[length + 1];
        for (int i = 0; i < length; i++) dp[i] = i;

        for (int j = 1; j <= length2; j++) {
            int pre = dp[0];
            dp[0] = j;
            for (int i = 1; i <= length; i++) {
                int temp = dp[i];
                dp[i] = word1.charAt(i - 1) == word2.charAt(j - 1) ? pre :
                        Math.min(Math.min(dp[i - 1], dp[i]), pre) + 1;
                pre = temp;
            }
        }
        return dp[length];
    }
}