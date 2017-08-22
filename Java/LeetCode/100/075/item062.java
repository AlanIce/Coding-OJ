class Solution {
    public int uniquePaths(int m, int n) {
        if (m > n) return uniquePaths(n, m);
        long count = 1;
        for (int i = n; i < m + n - 1; i++) count *= i;
        for (int i = 2; i < m; i++) count /= i;
        return (int) count;
    }
}