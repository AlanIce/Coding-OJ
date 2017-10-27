class Solution {
    public int countPrimes(int n) {
        if (n <= 2) return 0;
        boolean[] arr = new boolean[n];
        int num = n / 2;

        for (int i = 3; i * i < n; i += 2){
            if (arr[i]) continue;
            for (int j = i * i; j < n; j += 2 * i) {
                if (arr[j]) continue;
                --num;
                arr[j] = true;
            }
        }
        return num;
    }
}