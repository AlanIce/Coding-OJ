class Solution {
    public String minWindow(String s, String t) {
        char[] ss = s.toCharArray(), tt = t.toCharArray();
        int count = t.length(), lo = 0, hi = 0, begin = 0, minLength = Integer.MAX_VALUE;
        int[] hashmap = new int[128];
        for (char c : tt) hashmap[c]++;
        while (hi < s.length()) {
            if (hashmap[ ss[hi++] ]-- > 0) count--;
            while (count == 0 && lo < hi - t.length() + 1) {
                if (minLength > hi - lo) { begin = lo; minLength = hi - lo; }
                if (hashmap[ ss[lo++] ]++ == 0) count++;
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(begin, begin + minLength);
    }
}