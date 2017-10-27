import static java.lang.Math.min;
import static java.lang.Math.max;

class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int l = max(A,E);
        int r = max(min(C,G), l);
        int b = max(B,F);
        int t = max(min(D,H), b);
        int totalArea = (C - A) * (D - B) + (G - E) * (H - F);
        int otherArea = (r - l) * (t - b);
        return totalArea - otherArea;
    }
}