class Solution {
    private int[] hash = new int[128];

    public String removeDuplicateLetters(String s) {
        if (s.length() == 0) return "";
        Arrays.fill(hash, 0);
        char[] chars = s.toCharArray();
        int pos = 0;
        for (char c : chars) hash[c]++;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] < chars[pos]) pos = i;
            if (--hash[ chars[i] ] == 0) break;
        }
        return s.charAt(pos) + removeDuplicateLetters(s.substring(pos + 1).replaceAll("" + s.charAt(pos), ""));
    }
}