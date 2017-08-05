public class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.equals("")) return new LinkedList<String>();
        LinkedList<String> result = new LinkedList<String>();
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        result.add("");
        for (int i = 0; i < digits.length(); i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            while (result.peek().length() == i) {
                String t = result.remove();
                for (char c : mapping[x].toCharArray()) {
                    result.add(t + c);
                }
            }
        }
        return result;
    }
}