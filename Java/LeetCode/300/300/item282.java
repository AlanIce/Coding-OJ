class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> rst = new ArrayList<>();
        if(num == null || num.length() == 0) return rst;
        addOperators(num, target, "", 0, 0, 0, rst);
        return rst;
    }

    private void addOperators(String num, int target, String path, int pos, long eval, long mult, List<String> rst) {
        if (pos == num.length()) {
            if (eval == target) rst.add(path);
            return;
        }
        for (int i = pos + 1; i <= num.length(); i++) {
            if (i != pos + 1 && num.charAt(pos) == '0') break;
            long cur = Long.parseLong(num.substring(pos, i));
            if (pos == 0) addOperators(num, target, path + cur, i, cur, cur, rst);
            else {
                addOperators(num, target, path + "+" + cur, i, eval + cur, cur, rst);
                addOperators(num, target, path + "-" + cur, i, eval - cur, -cur, rst);
                addOperators(num, target, path + "*" + cur, i, eval - mult + mult * cur, mult * cur, rst);
            }
        }
    }
}