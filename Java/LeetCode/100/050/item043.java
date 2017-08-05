public class Solution {
    public String multiply(String num1, String num2) {
        char[] num = new char[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--)
            for (int j = num2.length() - 1; j >= 0; j--)
                num[i + j + 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
        for (int i = num1.length() + num2.length() - 1; i > 0; i--) {
            num[i - 1] += num[i] / 10;
            num[i] %= 10;
        }
        StringBuilder sb = new StringBuilder();
        for(int i : num) if(!(sb.length() == 0 && i == 0)) sb.append(i);
        return sb.length() == 0 ? "0" : sb.toString();
    }
}