class Solution {
    public int maxProduct(String[] words) {
        int[] bits = new int[words.length];
        for (int i = 0; i < words.length; i++)
            bits[i] = word2int(words[i]);
        int rst = 0;
        for (int i = 0; i < bits.length; i++)
            for (int j = i + 1; j < bits.length; j++)
                if ((bits[i] & bits[j]) == 0)
                    rst = Math.max(rst, words[i].length() * words[j].length());
        return rst;
    }
    
    private int word2int(String word) {
        int rst = 0;
        for (char c : word.toCharArray()) 
            rst |= 1 << (c - 'a' + 1);
        return rst;
    }
}