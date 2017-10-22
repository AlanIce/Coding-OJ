class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        System.out.println(String.format("%10d : %10d", m, n));
        long base = 1;
        while (base <= m) base <<= 1;
        base >>= 1;
        if (m >= base && n < base * 2)
            return (int)base + rangeBitwiseAnd(m - (int)base, n - (int)base);
        return 0;
    }
}