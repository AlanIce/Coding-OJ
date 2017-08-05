public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] hash = new int[256];
        int count = 0, result = 0, i = 0, j = 0;
        while (i < s.length()) {
            if (++hash[(int)s.charAt(i)] == 1) {
                if (++count > result) result = count;
            } else {
                while (s.charAt(j) != s.charAt(i)) {
                    hash[(int)s.charAt(j)]--;
                    count--;
                    j++;
                }
                hash[(int)s.charAt(j)]--;
                j++;
            }
            i++;
        }
        return result;
    }
}