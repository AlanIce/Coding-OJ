class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        int[] result = new int[length - k + 1];
        int index = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < length; i++) {
            while (!deque.isEmpty() && deque.peek() < i - k + 1) deque.poll();
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) deque.pollLast();
            deque.offer(i);
            if (i >= k - 1) result[index++] = nums[deque.peek()];
        }
        return result;
    }
}