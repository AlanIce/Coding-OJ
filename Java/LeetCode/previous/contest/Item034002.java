package priv.alanice.coding.leetcode.contest;

import java.util.*;

/**
 * Created by AlanIce on 2017/5/28.
 */
public class Item034002 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Set<String> set1 = new HashSet<String>();
        Set<String> set2 = new HashSet<String>();
        Collections.addAll(set1, list1);
        Collections.addAll(set2, list2);
        set1.retainAll(set2);
        List<String> list = new ArrayList<String>();
        int Minindex = Integer.MAX_VALUE;
        for (String str : set1) {
            int index = indexOf(list1, str) + indexOf(list2, str);
            if (index < Minindex) {
                Minindex = index;
                list.clear();
                list.add(str);
            } else if (index == Minindex) {
                list.add(str);
            }
        }
        String[] result = new String[list.size()];
        list.toArray(result);
        return result;
    }

    private int indexOf(String[] list, String str) {
        for (int i = 0; i < list.length; i++)
            if (list[i].equals(str))
                return i;
        return Integer.MAX_VALUE / 3;
    }
}
