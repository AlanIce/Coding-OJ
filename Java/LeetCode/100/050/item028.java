public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        int[] nextVal = getNextVal(needle);
        int i = 0, j = 0;
        while (i < haystack.length() && j < needle.length())
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) { i++; j++; }
            else j = nextVal[j];
        if (j < needle.length()) return -1;
        return i - j;
    }

    private int[] getNextVal(String pattern) {
        int[] nextVal = new int[pattern.length()];
        nextVal[0] = -1;
        int i = 0, j = -1;
        while (i < pattern.length() - 1) {
            if (j == -1 || pattern.charAt(i) == pattern.charAt(j)) {
                i++; j++;
                if (pattern.charAt(i) == pattern.charAt(j)) nextVal[i] = nextVal[j];
                else nextVal[i] = j;
            } else j = nextVal[j];
        }
        return nextVal;
    }
}