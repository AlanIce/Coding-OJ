class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int row = matrix.length, col = matrix[0].length;
        int[] l = new int[col], r = new int[col], h = new int[col];
        int result = 0;
        for (int i = 0; i < col; i++) r[i] = col;
        for (int j = 0; j < row; j++) {
            int cl = 0, cr = col;
            for (int i = col - 1; i >= 0; i--)
                if (matrix[j][i] == '1') r[i] = Math.min(cr, r[i]);
                else { r[i] = col; cr = i; }
            for (int i = 0; i < col; i++) {
                if (matrix[j][i] == '1') { l[i] = Math.max(cl, l[i]); h[i]++; }
                else { l[i] = 0; cl = i + 1; h[i] = 0; }
                result = Math.max(result, (int)Math.pow(Math.min(h[i], (r[i] - l[i])), 2));
            }
        }
        return result;
    }
}