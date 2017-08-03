public class Solution {
    boolean[][] graph;
    int N;
    int[] cache;

    public int findLongestChain(int[][] pairs) {
        N = pairs.length;
        graph = new boolean[N][N];
        cache = new int[N];
        for (int i = 0; i < N; i++) cache[i] = -1;
        for (int i = 0; i < N - 1; i++)
            for (int j = i + 1; j < N; j++) {
                if (pairs[i][1] < pairs[j][0]) graph[i][j] = true;
                else if (pairs[j][1] < pairs[i][0]) graph[j][i] = true;
            }
        int result = 0;
        for (int i = 0; i < N; i++) {
            int temp = DFS(i);
            if (temp > result) result = temp;
        }
        return result + 1;
    }

    private int DFS(int n) {
        if (cache[n] != -1) return cache[n];
        int result = 0;
        for (int i = 0; i < N; i++)
            if (graph[n][i]) {
                int temp = 1 + DFS(i);
                if (temp > result) result = temp;
            }
        cache[n] = result;
        return result;
    }
}