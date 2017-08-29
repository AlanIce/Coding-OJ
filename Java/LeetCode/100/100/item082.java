class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode sentry = new ListNode(0), p = sentry;
        sentry.next = head;
        while (p != null) {
            ListNode q = p.next;
            while (q != null && q.next != null && q.val == q.next.val)
                q = q.next;
            if (q != p.next && q != null) p.next = q.next;
            else p = p.next;
        }
        return sentry.next;
    }
}