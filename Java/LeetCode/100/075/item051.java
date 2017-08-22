import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new LinkedList<>();
        int[] queens = new int[n];
        solveNQueens(queens, n, 0, result);
        return result;
    }

    private void solveNQueens(int[] queens, int n, int index, List<List<String>> result) {
        if (index == n) {
            result.add(handleResult(queens));
            return;
        }
        for (int i = 0; i < n; i++) {
            queens[index] = i;
            boolean vaild = true;
            for (int j = 0; j < index; j++)
                if (queens[j] == i || index - j == Math.abs(i - queens[j])) {
                    vaild = false;
                    break;
                }
            if (vaild) solveNQueens(queens, n, index + 1, result);
        }
    }
    private List<String> handleResult(int[] queens) {
        List<String> list = new ArrayList<>();
        for (int queen : queens) {
            list.add(handleLine(queen, queens.length));
        }
        return list;
    }

    private String handleLine(int index, int n) {
        char[] chars = new char[n];
        for (int i = 0; i < n; i++) chars[i] = '.';
        chars[index] = 'Q';
        return new String(chars);
    }
}