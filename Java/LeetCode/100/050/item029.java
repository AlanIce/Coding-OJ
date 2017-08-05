public class Solution {
    public int divide(int dividend, int divisor) {
        int sign = ( dividend > 0 ^ divisor > 0 ) ? -1 : 1;
        if (divisor == 0) return dividend < 0 ? Integer.MAX_VALUE : Integer.MAX_VALUE;
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        int result = 0;
        while (a >= b) {
            long mult = 1, sum = b;
            while ( (sum + sum) <= a ) {
                sum += sum;
                mult += mult;
            }
            result += mult;
            a -= sum;
        }
        return sign == 1 ? result : -result;
    }
}