class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int M = A.length;
        int N = B.length;
        if (M > N)
            return findMedianSortedArrays(B, A);

        int k = (M + N - 1) / 2;
        int l = 0, r = Math.min(k, M);
        while (l < r) {
            int midA = (l + r) / 2;
            int midB = k - midA;
            if (A[midA] < B[midB]) l = midA + 1;
            else r = midA;
        }
        int a = Math.max(l > 0 ? A[l - 1] : Integer.MIN_VALUE, k - l >= 0 ? B[k - l] : Integer.MIN_VALUE);
        if (((M + N) & 1) == 1)
            return (double) a;
        int b = Math.min(l < M ? A[l] : Integer.MAX_VALUE, k - l + 1 < N ? B[k - l + 1] : Integer.MAX_VALUE);
        return (a + b) / 2.0;
    }
}