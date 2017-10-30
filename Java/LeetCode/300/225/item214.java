class Solution {
    public String shortestPalindrome(String s) {
        int i = 0;
        for (int j = s.length() - 1; j >= 0; j--)
            if (s.charAt(j) == s.charAt(i)) i++;
        if (i == s.length()) return s;
        String suffix = s.substring(i);
        return new StringBuffer(suffix).reverse().toString() + shortestPalindrome(s.substring(0, i)) + suffix;
    }
}