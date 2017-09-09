class Solution {
    public int maxPoints(Point[] points) {
        int n = points.length;
        if(n < 3) return n;

        Arrays.sort(points, (a, b) -> { if(a.x == b.x) return a.y - b.y; return a.x - b.x; });

        //time optimization - true when pair has been checked
        //only uses the half where row < column
        boolean[][] checked = new boolean[n][n];

        int answer = 2;
        for (int i = 0; i < n; i++) {
            /*
             *   The greatest possible number of points we can have starting at i is n-i.
             *   Since it's ordered, we have gone through our greatest possibilites first.
             */
            if (answer >= n - i) return answer;
            Point a = points[i];
            for (int j = n - 1; j > i; j--) {
                /*
                 *   Once the number of points we can check between i and j is less than
                 *   our current answer, we won't be able to do any better for this i.
                 *   We also can break if we checked this combination.
                */
                if (j - i + 1 <= answer || checked[i][j]) break;
                Point b = points[j];
                int pointCount = 2;
                for (int k = i + 1; k < j; k++) {
                    //Check how many points on the line between point[i] and point[j]
                    if(pointCount + j - k <= answer) break;
                    if(pointOnLine(a, b, points[k])) {
                        checked[i][k] = true;
                        checked[k][j] = true;
                        pointCount++;
                    }
                }
                answer = Math.max(pointCount, answer);
            }
        }
        return answer;
    }
    private boolean pointOnLine(Point a, Point b, Point check) {
        return (long) (check.x - a.x) * (b.y - check.y) == (long) (b.x - check.x) * (check.y - a.y);
    }
}