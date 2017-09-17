class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int diff = getListNodeLength(headA) - getListNodeLength(headB);
        while (diff != 0) {
            if (diff > 0) {
                headA = headA.next;
                diff--;
            } else {
                headB = headB.next;
                diff++;
            }
        }
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    private int getListNodeLength(ListNode head) {
        int length = 0;
        while (head != null) {
            head = head.next;
            length++;
        }
        return length;
    }
}