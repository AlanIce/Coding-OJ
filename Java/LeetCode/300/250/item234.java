class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode f = head;
        ListNode s = head;
        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }
        if (f != null) s = s.next;
        s = reverse(s);
        f = head;
        while (s != null) {
            if (f.val != s.val) return false;
            f = f.next;
            s = s.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null, next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}