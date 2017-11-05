class Solution {
    public String getHint(String secret, String guess) {
        char[] a = secret.toCharArray();
        char[] b = guess.toCharArray();
        int A = 0, B = 0, len = a.length;
        int[] hash = new int[10];
        for (int i = 0; i < len; i++)
            if (a[i] == b[i]) A++;
        for (int i = 0; i < len; i++)
            hash[a[i] - '0']++;
        for (int i = 0; i < len; i++)
            if (hash[b[i] - '0']-- > 0) B++;
        return A + "A" + (B - A) + "B";
    }
}