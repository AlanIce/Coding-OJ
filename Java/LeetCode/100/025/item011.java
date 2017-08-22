class Solution {
    public int maxArea(int[] height) {
        int lo = 0, hi = height.length - 1, res = 0;
        while (lo < hi) {
            int h = height[lo] < height[hi] ? height[lo] : height[hi];
            res = (hi - lo) * h > res ? (hi - lo) * h : res;
            while (height[lo] <= h && lo < hi) lo++;
            while (height[hi] <= h && lo < hi) hi--;
        }
        return res;
    }
}