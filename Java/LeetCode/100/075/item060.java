public class Solution {
    public String getPermutation(int n, int k) {
        k--;
        List<Integer> list = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) list.add(i);
        int t = 1;
        for (int i = 2; i < n; i++) t *= i;
        for (int i = n - 1; i >= 0; i--) {
            int m = k / t;
            sb.append(list.get(m));
            list.remove(m);
            k %= t;
            if (i != 0) t /= i;
        }
        return sb.toString();
    }
}