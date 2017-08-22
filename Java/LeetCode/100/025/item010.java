class Solution {
    public boolean isMatch(String s, String p) {
        if (s.equals("") && p.equals("")) return true;
        if (!s.equals("") && p.equals("")) return false;
        if (p.length() > 1 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2)) ||
                    (s.length() != 0 && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0)) && isMatch(s.substring(1), p));
        }
        if (s.length() != 0 && p.length() != 0 && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0)))
            return isMatch(s.substring(1), p.substring(1));
        return false;
    }
}