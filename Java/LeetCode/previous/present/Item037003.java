package priv.alanice.coding.leetcode.present;

public class Item037003 {

    public int maxDistance(int[][] arrays) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int minpos = -1;
        int maxpos = -1;

        for (int i = 0; i < arrays.length; i++) {
            int[] array = arrays[i];
            if (array[0] < min) { min = array[0]; minpos = i; }
            if (array[array.length - 1] > max) { max = array[array.length - 1]; maxpos = i; }
        }
        if (minpos == maxpos) {
            int t1 = Integer.MAX_VALUE;
            int t2 = Integer.MIN_VALUE;
            for (int i = 0; i < arrays.length; i++) {
                int[] array = arrays[i];
                if (array[0] < t1 && i != minpos)
                    t1 = array[0];
                if (array[array.length - 1] > t2 && i != maxpos)
                    t2 = array[array.length - 1];
            }
            int t = (t1 - min < max - t2) ? t1 - min : max - t2;
            return max - min - t;
        }
        return max - min;
    }

}
