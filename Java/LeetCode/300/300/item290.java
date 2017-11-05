class Solution {
    public boolean wordPattern(String pattern, String str) {
        Map<Character, Integer> cMap = new HashMap<>();
        Map<String, Integer> sMap = new HashMap<>();
        char[] c = pattern.toCharArray();
        String[] s = str.split(" ");
        if (c.length != s.length) return false;
        int length = c.length;
        for (int i = 0; i < length; i++) {
            int cn = cMap.getOrDefault(c[i], 0);
            int sn = sMap.getOrDefault(s[i], 0);
            if (cn != sn) return false;
            cMap.put(c[i], i + 1);
            sMap.put(s[i], i + 1);
        }
        return true;
    }
}