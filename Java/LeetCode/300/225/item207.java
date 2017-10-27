class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int edge_len = prerequisites.length;
        int[] edge_next = new int[edge_len];
        int[] last = new int [numCourses];
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) last[i] = -1;

        for (int i = 0; i < edge_len; i++) {
            int x = prerequisites[i][1];
            indegree[prerequisites[i][0]]++;
            edge_next[i] = last[x];
            last[x] = i;
        }
        int[] queue = new int[numCourses];
        int l = -1, r = -1;
        for (int i = 0; i < numCourses; i++)
            if (indegree[i] == 0) queue[++r] = i;

        while (l < r) {
            int now = queue[++l];
            int edge_now = last[now];
            while (edge_now != -1) {
                indegree[ prerequisites[edge_now][0] ]--;
                if (indegree[ prerequisites[edge_now][0] ] == 0)
                    queue[++r] = prerequisites[edge_now][0];
                edge_now = edge_next[edge_now];
            }
        }
        return r + 1 == numCourses;
    }
}