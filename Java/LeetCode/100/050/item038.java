class Solution {
    public String countAndSay(int n) {
        StringBuilder s = new StringBuilder("1");
        for (int i = 1; i < n; i++) {
            StringBuilder t = new StringBuilder();
            for (int j = 0; j < s.length(); j++) {
                int count = 1;
                while (j < s.length() - 1 && s.charAt(j) == s.charAt(j + 1)) {
                    j++; count++;
                }
                t.append(count);
                t.append(s.charAt(j));
            }
            s = t;
        }
        return s.toString();
    }
}