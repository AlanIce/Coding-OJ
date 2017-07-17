package priv.alanice.coding.leetcode.easy;

import java.util.Arrays;

/**
 * Created by AlanIce on 2017/4/26.
 */
public class Item561 {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length; i += 2) result += nums[i];
        return result;
    }
}
