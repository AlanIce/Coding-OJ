class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0, maybePoint = -1, owned = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            if (sum >= 0) {
                if (maybePoint == -1)
                    maybePoint = i;
            } else {
                maybePoint = -1;
                owned += sum;
                sum = 0;
            }
        }
        return sum + owned >= 0 ? maybePoint : -1;
    }
}