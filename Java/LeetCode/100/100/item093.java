class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new LinkedList<>();
        restoreIpAddresses(s, 4, "", result);
        return result;
    }

    private void restoreIpAddresses(String s, int depth, String temp, List<String> result) {
        if (s.length() < depth || s.length() > 3 * depth) return;
        if (depth == 0 && s.length() == 0) result.add(temp.substring(0, temp.length() - 1));
        else if (s.charAt(0) == '0')
            restoreIpAddresses(s.substring(1), depth - 1, temp + "0.", result);
        else
            for (int i = 1; i <= 3 && i <= s.length(); i++) {
                String str = s.substring(0, i);
                if (Integer.parseInt(str) < 256)
                    restoreIpAddresses(s.substring(i), depth - 1, temp + str + ".", result);
            }
    }
}