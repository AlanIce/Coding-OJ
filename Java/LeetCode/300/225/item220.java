class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums == null || nums.length ==0 || k < 0 || t < 0)
            return false;
        TreeSet<Long> treeset = new TreeSet<>();
        for (int i = 0; i < nums.length; i++){
            if (i > k) treeset.remove((long)nums[i-k-1]);
            Long max = treeset.floor((long)nums[i] + t);
            if (max != null && max >= (long)nums[i] - t)
                return true;
            treeset.add((long)nums[i]);
        }
        return false;
    }
}