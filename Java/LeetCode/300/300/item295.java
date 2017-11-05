class MedianFinder {
    private PriorityQueue<Integer> s;
    private PriorityQueue<Integer> l;

    /** initialize your data structure here. */
    public MedianFinder() {
        s = new PriorityQueue<>();
        l = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        if (s.isEmpty() || num > s.peek()) {
            s.add(num);
        } else {
            l.add(num);
        }
        if (s.size() < l.size())
            s.add(l.poll());
        else if (s.size() > l.size() + 1)
            l.add(s.poll());
    }

    public double findMedian() {
        return s.size() > l.size() ? s.peek() : (l.peek() + s.peek()) / 2.0;
    }
}