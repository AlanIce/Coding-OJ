class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] uglgs = new int[n];
        uglgs[0] = 1;
        int index = 0;
        int[] indexs = new int[primes.length];
        while (++index < n) {
            int temp = Integer.MAX_VALUE;
            for (int i = 0; i < primes.length; i++)
                temp = Math.min(temp, uglgs[ indexs[i] ] * primes[i]);
            for (int i = 0; i < primes.length; i++)
                if (temp == uglgs[ indexs[i] ] * primes[i]) indexs[i]++;
            uglgs[index] = temp;
        }
        return uglgs[n - 1];
    }
}