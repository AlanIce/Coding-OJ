public class Solution {
    public int longestValidParentheses(String s) {
        int result = 0;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') st.push(i);
            else if (s.charAt(i) == ')')
                if (!st.empty() && s.charAt(st.peek()) == '(') st.pop();
                else st.push(i);
        }
        int a = s.length(), b;
        while (!st.empty()) {
            b = st.pop();
            if (result < a - b) result = a - b;
            a = b;
        }
        if (result < a + 1) result = a + 1;
        return result - 1;
    }
}

public class Solution {
    public int longestValidParentheses(String s) {
        int result = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') dp[i] = i > 1 ? 2 + dp[i - 2] : 2;
                else if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(')
                    dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0);
                if (result < dp[i]) result = dp[i];
            }
        }
        return result;
    }
}