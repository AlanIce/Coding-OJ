class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = "";
        char c;
        for (int i = 0; strs.length > 0; prefix += strs[0].charAt(i), i++)
            for (int j = 0; j < strs.length; j++)
                if (strs[j].length() <= i || strs[j].charAt(i) != strs[0].charAt(i))
                    return prefix;
        return prefix;
    }
}