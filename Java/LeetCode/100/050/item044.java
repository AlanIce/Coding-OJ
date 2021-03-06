@Deprecated
//(TimeLimitExceededException)
class Solution {
    public boolean isMatch(String s, String p) {
        if (s.length() == 0 && p.length() == 0) return true;
        if (s.length() != 0 && p.length() == 0) return false;
        if (s.length() > 0 && (p.charAt(0) == '?' || s.charAt(0) == p.charAt(0))) return isMatch(s.substring(1), p.substring(1));
        if (p.charAt(0) == '*') return isMatch(s, p.substring(1)) || (s.length() > 0 && isMatch(s.substring(1), p));
        return false;
    }
}

class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int j = 0; j < p.length(); j++)
            if (p.charAt(j) == '*' && dp[0][j]) dp[0][j+1] = true;
        for (int i = 0; i < s.length(); i++)
            for (int j = 0; j < p.length(); j++)
                if (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j)) dp[i+1][j+1] = dp[i][j];
                else if (p.charAt(j) == '*') dp[i+1][j+1] = dp[i][j+1] || dp[i+1][j];
        return dp[s.length()][p.length()];
    }
}