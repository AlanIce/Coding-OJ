class Solution {
    public String longestPalindrome(String s) {
        String result = "";
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s, i - len - 1, i)) {
                result = s.substring(i - len - 1, i + 1);
                len += 2;
            } else if (isPalindrome(s, i - len, i)) {
                result = s.substring(i - len, i + 1);
                len += 1;
            }
        }
        return result;
    }

    private boolean isPalindrome(String s, int lo, int hi) {
        if (lo < 0) return false;
        while (lo < hi)
            if (s.charAt(lo++) != s.charAt(hi--)) return false;
        return true;

    }
}