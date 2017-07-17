package priv.alanice.coding.leetcode.contest;

/**
 * Created by AlanIce on 2017/5/28.
 */
public class Item034001 {
    public int maxCount(int m, int n, int[][] ops) {
        int x = m, y = n;
        for (int[] item : ops) {
            if (item[0] != 0 && item[0] < x)
                x = item[0];
            if (item[1] != 0 && item[1] < y)
                y = item[1];
        }
        return x * y;
    }
}
