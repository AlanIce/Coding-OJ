class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int n : nums) {
            max = Math.max(max, n);
            min = Math.min(min, n);
        }
        if (min == max) return 0;
        int bucket_gap = (int) Math.ceil((double)(max - min) / (nums.length - 1));
        int[] bucket_max = new int[nums.length];
        Arrays.fill(bucket_max, Integer.MIN_VALUE);
        int[] bucket_min = new int[nums.length];
        Arrays.fill(bucket_min, Integer.MAX_VALUE);
        for (int n : nums) {
            int index = (n - min) / bucket_gap;
            bucket_max[index] = Math.max(bucket_max[index], n);
            bucket_min[index] = Math.min(bucket_min[index], n);
        }
        int result = 0, previous = min;
        for (int i = 0; i < nums.length; i++) {
            if (bucket_max[i] == Integer.MIN_VALUE && bucket_min[i] == Integer.MAX_VALUE) continue;
            result = Math.max(result, bucket_min[i] - previous);
            previous = bucket_max[i];
        }
        return result;
    }
}