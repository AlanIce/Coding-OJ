class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode midd = slow.next;
        slow.next = null;
        ListNode l = sortList(head);
        ListNode r = sortList(midd);
        return merge(l, r);
    }

    public ListNode merge(ListNode l, ListNode r) {
        if (l == null) return r;
        if (r == null) return l;
        if (l.val < r.val) {
            l.next = merge(l.next, r);
            return l;
        }else {
            r.next = merge(l, r.next);
            return r;
        }
    }
}