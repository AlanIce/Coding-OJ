class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = s.length();
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';
        char[] chars = s.toCharArray();
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(chars[i]))
                num = num * 10 + chars[i] - '0';
            if ((!Character.isDigit(chars[i]) && chars[i] != ' ') || i == len - 1) {
                if (sign == '-')
                    stack.push(-num);
                else if (sign == '+')
                    stack.push(num);
                else if (sign == '*')
                    stack.push( stack.pop() * num);
                else if (sign == '/')
                    stack.push(stack.pop() / num);
                sign = s.charAt(i);
                num = 0;
            }
        }
        int sum = 0;
        for (int i : stack) sum += i;
        return sum;
    }
}