class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] a = new int[256], b = new int[256];
        char[] sc = s.toCharArray(), tc = t.toCharArray();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (a[sc[i]] != b[tc[i]]) return false;
            a[sc[i]] = i + 1;
            b[tc[i]] = i + 1;            
        }
        return true;
    }
}