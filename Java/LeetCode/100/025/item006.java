public class Solution {
    public String convert(String s, int numRows) {
        if (numRows < 2) return s;
        int len = s.length();
        char[] src = s.toCharArray();
        char[] res = new char[len];
        int index = 0;
        // first line
        for (int i = 0; i < len; i += 2 * numRows - 2)
            res[index++] = src[i];
        // middle lines
        for (int i = 1; i < numRows - 1; i++)
            for (int j = i; j < len; j += 2 * numRows - 2) {
                res[index++] = src[j];
                if (j + (numRows - i - 1) * 2 < len)
                    res[index++] = src[j + (numRows - i - 1) * 2];
            }
        // last line
        for (int i = numRows - 1 ; i < len; i += 2 * numRows - 2)
            res[index++] = src[i];
        return new String(res);
    }
}