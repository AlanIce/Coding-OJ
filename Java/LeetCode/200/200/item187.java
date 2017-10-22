class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int length = s.length();
        char[] map = new char[255];
        map['A'] = 0; map['C'] = 1; map['G'] = 2; map['T'] = 3;
        char[] chars = s.toCharArray();
        Set<Integer> seen = new HashSet<>();
        Set<Integer> repeat = new HashSet<>();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < length - 9; i++) {
            int t = 0;
            for (int j = 0; j < 10; j++) {
                t <<= 2;
                t |= map[chars[i + j]];
            }
            String subStr = s.substring(i, i + 10);
            if (!seen.add(t) && repeat.add(t))
                result.add(subStr);
        }
        return result;
    }
}