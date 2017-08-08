public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1;
        boolean carry = false, c, d;
        while (i >= 0 || j >= 0 || carry) {
            c = d = false;
            if (i >= 0) c = a.charAt(i--) == '1';
            if (j >= 0) d = b.charAt(j--) == '1';
            sb.insert(0, (char)(carry ^ c ^ d ? '1' : '0'));
            carry = (carry && c) || (c && d) || (d && carry);
        }
        return sb.toString();
    }
}