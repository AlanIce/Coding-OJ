public class Solution {
    public String reverseWords(String s) {
        char[] chs = s.toCharArray();
        reverse(chs, 0, chs.length - 1);
        int startIndex = 0, endIndex = 0;
        for (endIndex = 0; endIndex <= chs.length; endIndex++) {
            if (endIndex == chs.length || chs[endIndex] == ' ') {
                reverse(chs, startIndex, endIndex - 1);
                startIndex = endIndex + 1;
            }
        }
        return cleanSpace(chs);
    }

    private void reverse(char[] chs, int lo, int hi) {
        while (lo < hi) {
            char t = chs[lo];
            chs[lo++] = chs[hi];
            chs[hi--] = t;
        }
    }

    private String cleanSpace(char[] chs) {
        int i = 0, j = 0;
        while (i < chs.length) {
            while (i < chs.length && chs[i] == ' ') i++;
            while (i < chs.length && chs[i] != ' ') chs[j++] = chs[i++];
            while (i < chs.length && chs[i] == ' ') i++;
            if (i < chs.length)chs[j++] = ' ';
        }
        return new String(chs).substring(0, j);
    }
}