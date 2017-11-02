class Solution {
    public int nthUglyNumber(int n) {
        int[] uglgs = new int[n];
        uglgs[0] = 1;
        int index = 0, index2 = 0, index3 = 0, index5 = 0;
        while (++index < n) {
            int temp = Math.min( Math.min(uglgs[index2] * 2, uglgs[index3] * 3), uglgs[index5] * 5 );
            if (temp == uglgs[index2] * 2) index2++;
            if (temp == uglgs[index3] * 3) index3++;
            if (temp == uglgs[index5] * 5) index5++;
            uglgs[index] = temp;
        }
        return uglgs[n - 1];
    }
}