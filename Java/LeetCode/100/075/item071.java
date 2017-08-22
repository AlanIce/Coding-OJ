class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        List<String> skip = Arrays.asList("..",".","");
        for (String dir : path.split("/")) {
            if (dir.equals("..") && !stack.isEmpty()) stack.pop();
            else if (!skip.contains(dir)) stack.push(dir);
        }
        String res = "";
        for (String dir : stack) res = "/" + dir + res;
        return res.isEmpty() ? "/" : res;
    }
}