class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode sentry = new ListNode(0), pre = sentry, cur = pre;
        sentry.next = head;
        while (cur != null) {
            ListNode next = cur.next;
            if (next != null && next.val < x) {
                if (cur == pre) pre = cur = pre.next;
                else {
                    cur.next = next.next;
                    next.next = pre.next;
                    pre.next = next;
                    pre = next;
                }
            } else cur = cur.next;
        }
        return sentry.next;
    }
}