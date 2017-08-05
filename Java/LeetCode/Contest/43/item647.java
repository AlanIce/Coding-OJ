public class Solution {
    
    int N;
    
    public int countSubstrings(String s) {
        N = s.length();
        int result = 0;
        for (int i = 0; i < N; i++) 
            result += expandPalindrome(s, i, i) + expandPalindrome(s, i, i + 1);
        return result;
    }

    private int expandPalindrome(String s, int lo, int hi) {
        int result = 0;
        while (lo >= 0 && hi < N && s.charAt(lo--) == s.charAt(hi++)) 
            result++;
        return result;
    }
}