public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int a = 0x80000000, b = 0x1;
        while (a < 0 || a > b) {
            if ( ((n & a) == 0) != ((n & b) == 0) ) {
                n ^= a;
                n ^= b;
            }
            a >>>= 1;
            b <<= 1;
        }
        return n;
    }
}