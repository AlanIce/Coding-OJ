package priv.alanice.coding.leetcode.contest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by AlanIce on 2017/5/28.
 */
public class Item034004 {
    public int findIntegers(int num) {
        return findIntegers(num, new HashMap<Integer, Integer>());
    }

    public int findIntegers(int num, Map<Integer, Integer> memo) {
        if (num <= 2) return num + 1; // base case
        if (memo.containsKey(num)) return memo.get(num); // check if this result has already been computed

        int msb = 31 - Integer.numberOfLeadingZeros(num); // retrieve index of most significant bit
        int subNum = (1 << msb) - 1, subNum2 = ~(1 << msb) & num;
        if (subNum2 >= 1 << msb - 1) subNum2 = subNum >> 1;
        int result = findIntegers(subNum, memo) + findIntegers(subNum2, memo);

        memo.put(num, result); // add result to memo
        return result;
    }
}
