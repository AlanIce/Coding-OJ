class Solution {
    public List<List<String>> partition(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        char[] cArray = s.toCharArray();
        for(int i = 0; i < cArray.length; i++){
            for(int j = 0; j <= i; j++){
                if(cArray[i] == cArray[j] && (i - j <= 2 || dp[i - 1][j + 1]))
                    dp[i][j] = true;
            }
        }
        List<List<String>> ll = new ArrayList<>();
        helper(dp, ll, new ArrayList<>(), 0, s);
        return ll;
    }

    public void helper(boolean[][] dp, List<List<String>> ll, List<String> list, int pos, String s) {
        if(pos == dp.length) {
            ll.add(new ArrayList<>(list));
            return;
        }
        for(int i = pos; i < dp.length; i++){
            if (dp[i][pos]) {
                list.add(s.substring(pos, i+1));
                helper(dp, ll, list, i + 1, s);
                list.remove(list.size() - 1);
            }
        }
    }
