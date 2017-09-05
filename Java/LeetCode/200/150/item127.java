import java.util.*;

public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || wordList == null) return 0;

        Set<String> begin = new HashSet<>();
        Set<String> end = new HashSet<>();
        for (String s : wordList) {
            begin.add(s);
            end.add(s);
        }
        if (!end.contains(endWord)) {
            return 0;
        } else {
            end.add(beginWord);
            end.remove(endWord);
        }
        begin.remove(beginWord);
        Queue<String> beginQueue = new LinkedList<>();
        Queue<String> endQueue = new LinkedList<>();
        beginQueue.offer(beginWord);
        endQueue.offer(endWord);
        boolean match = false;
        int step = 2;
        while (!beginQueue.isEmpty() && !endQueue.isEmpty()) {
            if (beginQueue.size() >= endQueue.size()) {
                match = check(end, endQueue, begin);
            } else {
                match = check(begin, beginQueue, end);
            }
            if (match) {
                return step;
            } else {
                step++;
            }
        }
        return 0;
    }
    private boolean check(Set<String> set, Queue<String> queue, Set<String> other) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            String cur = queue.poll();
            char[] array = cur.toCharArray();
            for (int j = 0; j < array.length; j++) {
                char c = array[j];
                for (char k = 'a'; k <= 'z'; k++) {
                    if (c != k) {
                        array[j] = k;
                        String temp = new String(array);
                        if (set.contains(temp)) {
                            if (!other.contains(temp)) {
                                return true;
                            } else {
                                queue.offer(temp);
                                set.remove(temp);
                            }
                        }
                    }
                }
                array[j] = c;
            }
        }
        return false;
    }
}