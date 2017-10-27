class Solution {
    static class Node {
        int x, y;
        Node next;
    }

    static Node getHead(Node head, int x1, int x2, int y) {
        final Node next = new Node();
        next.x = x2;
        head.x = x1;
        head.y = y;
        head.next = next;
        return head;
    }

    static void addResult(List<int[]> result, int x, int y) {
        if(result.isEmpty() || result.get(result.size() - 1)[1] != y) {
            result.add(new int[] {x, y});
        }
    }

    static Node merge(List<int[]> result, Node head, int x1, int x2, int y) { // x1 >= head.x, x2 > x1, y > 0
        if(x1 > head.x) {
            addResult(result, head.x, head.y);
        }
        final Node next = head.next;
        if (null == next) 
            return getHead(head, x1, x2, y);
        else if (x1 >= next.x)  // below next != null
            return merge(result, next, x1, x2, y);
        else if (x2 >= next.x) { // below x1 < next.x
            if (y > head.y) {
                head.y = y;
            }
            head.x = x1;
            if(x2 > next.x) {
                head.next = merge(result, next, next.x, x2, y);
            }
            return head;
        } else { // below x2 < next.x
            if (y > head.y) {
                final Node insert = new Node();
                insert.x = x2;
                insert.y = head.y;
                insert.next = next;
                head.next = insert;
                head.y = y;
            }
            head.x = x1;
            return head;
        }
    }

    public List<int[]> getSkyline(int[][] buildings) {
        if (buildings == null) return null;
        final int n = buildings.length;
        if (n < 1) return Collections.emptyList();
        final List<int[]> result = new ArrayList<>(2 * n);
        int[] building = buildings[0];
        Node head = getHead(new Node(), building[0], building[1], building[2]);
        for (int i = 1; i < n; i++) {
            building = buildings[i];
            head = merge(result, head, building[0], building[1], building[2]);
        }
        while(head != null) {
            addResult(result, head.x, head.y);
            head = head.next;
        }
        return result;
    }
}