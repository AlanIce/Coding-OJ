class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int sum = 0, num = 0;
        char[] chars = s.toCharArray();
        int lastOp = 1;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
            } else if (c == '+') {
                sum += lastOp * num;
                num = 0;
                lastOp = 1;
            } else if (c == '-') {
                sum += lastOp * num;
                num = 0;
                lastOp = -1;
            } else if (c == '(') {
                st.push(sum);
                st.push(lastOp);
                lastOp = 1;
                sum = 0;
                num = 0;
            } else if (c == ')') {
                sum += lastOp * num;
                num = 0;
                sum *= st.pop();
                sum += st.pop();
            }
        }
        return sum + lastOp * num;
    }
}