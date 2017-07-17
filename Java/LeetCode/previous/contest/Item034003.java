package priv.alanice.coding.leetcode.contest;

/**
 * Created by AlanIce on 2017/5/28.
 */
public class Item034003 {
    public int arrayNesting(int[] nums) {
        int result = 0;
        boolean[] flag = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (flag[i] == false) {
                int length = 0;
                int index = i;
                while (flag[index] == false) {
                    flag[index] = true;
                    length++;
                    index = nums[index];
                }
                if (length > result)
                    result = length;
            }
        }
        return result;
    }
}
