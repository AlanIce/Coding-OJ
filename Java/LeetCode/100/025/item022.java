class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        generateParenthesisCore("", result, 0, 0, n);
        return result;
    }

    private void generateParenthesisCore(String s, List<String> list, int open, int close, int n) {
        if (open + close == 2 * n) {
            list.add(s);
            return;
        }
        if (open < n) generateParenthesisCore(s + "(", list, open + 1, close, n);
        if (open > close) generateParenthesisCore(s + ")", list, open, close + 1, n);

    }
}