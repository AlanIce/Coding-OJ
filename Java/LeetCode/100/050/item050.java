class Solution {
    public double myPow(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        return myPowCore(x, n);
    }
    
    private double myPowCore(double x, int n) {
        if (n == 0) return 1;
        return n % 2 == 0 ? myPowCore(x * x, n / 2) : x * myPowCore(x * x, n / 2);
    }
}