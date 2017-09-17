class Solution {
    public int titleToNumber(String s) {
        char[] chs = s.toCharArray();
        int result = 0;
        for (int i = 0; i < chs.length; i++) {
            result *= 26;
            result += (int)(chs[i] - 'A' + 1);
        }
        return result;
    }
}