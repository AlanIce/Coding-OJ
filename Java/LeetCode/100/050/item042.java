public class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1, ml = 0, mr = 0, count = 0;
        while (l <= r) {
            if (height[l] < height[r])
                if (height[l] > ml) ml = height[l];
                else count += ml - height[l++];
            else
                if (height[r] > mr) mr = height[r];
                else count += mr - height[r--];
        }
        return count;
    }
}