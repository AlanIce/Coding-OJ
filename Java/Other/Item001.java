public class Solution {
    private static String func(int decimal1, int decimal2, String numStr) {
        int num = decode(decimal1, numStr);
        return encode(decimal2, num);
    }

    private static String encode(int decimal, int num) {
        List<Character> list = new LinkedList<>();
        while (num > 0) {
            list.add(int2char((int)num % decimal));
            num /= decimal;
        }
        Collections.reverse(list);
        char[] chars = new char[list.size()];
        for (int i = 0; i < list.size(); i++)
            chars[i] = list.get(i);
        return new String(chars);
    }

    private static int decode(int decimal, String numStr) {
        int num = 0;
        char[] chars = numStr.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            num *= decimal;
            num += char2int(chars[i]);
        }
        return num;
    }

    private static int char2int(char c) {
        if (c >= '0' && c <= '9') return c - '0';
        if (c >= 'a' && c <= 'z') return c - 'a' + 10;
        if (c >= 'A' && c <= 'Z') return c - 'A' + 36;
        return 0;
    }

    private static char int2char(int i) {
        if (i >= 0 && i <= 9) return (char)(i + '0');
        if (i >= 10 && i <= 35) return (char)(i + 'a' - 10);
        if (i >= 36 && i <= 61) return (char)(i + 'A' - 36);
        return (char) 0;
    }
}