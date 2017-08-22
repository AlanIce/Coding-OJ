class Solution {
    public int lengthOfLastWord(String s) {
        int index = s.length(), count = 0;
        while (--index >= 0 && s.charAt(index) == ' ') ;
        index++;
        while (--index >= 0)
            if (s.charAt(index) == ' ') return count;
            else count++;
        return count;
    }
}