class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        if (sc.length != tc.length) return false;
        int[] hash = new int[128];
        for (char c : sc) hash[c]++;
        for (char c : tc) hash[c]--;
        for (int i : hash) if (i != 0) return false;
        return true;
    }
}