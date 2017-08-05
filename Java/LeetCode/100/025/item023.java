public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            public int compare(ListNode o1, ListNode o2) { return o1.val < o2.val ? -1 : 1; }
        });
        for (ListNode node : lists)
            if (node != null) pq.add(node);
        ListNode head = new ListNode(0), tail = head;
        while (!pq.isEmpty()) {
            tail.next = pq.poll();
            tail = tail.next;
            if (tail.next != null) pq.add(tail.next);
        }
        return head.next;
    }
}