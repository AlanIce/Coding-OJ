public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        RandomListNode curr = head;
        while (curr != null) {
            RandomListNode cloneNode = new RandomListNode(curr.label);
            cloneNode.next = curr.next;
            cloneNode.random = curr.random;
            curr.next = cloneNode;
            curr = cloneNode.next;
        }
        curr = head;
        while (curr != null) {
            RandomListNode cloneNode = curr.next;
            if (curr.random != null) cloneNode.random = curr.random.next;
            curr = cloneNode.next;
        }
        RandomListNode cloneHead = head.next;
        curr = head;
        while(curr.next != null){
            RandomListNode next = curr.next;
            curr.next = next.next;
            curr = next;
        }
        return cloneHead;
    }
}