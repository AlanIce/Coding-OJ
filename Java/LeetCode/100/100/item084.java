class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] l = new int[heights.length];
        int[] r = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            int t = i - 1;
            while (t >= 0 && heights[t] >= heights[i]) t = l[t];
            l[i] = t;
        }
        for (int i = heights.length - 1; i >= 0; i--) {
            int t = i + 1;
            while (t < heights.length && heights[t] >= heights[i]) t = r[t];
            r[i] = t;
        }
        int result = 0;
        for (int i = 0; i < heights.length; i++)
            result = Math.max(result, heights[i] * (r[i] - l[i] - 1));
        return result;
    }
}