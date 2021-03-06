class Solution {
    private Map<String, List<Integer>> map = new HashMap<>();
    
    public List<Integer> diffWaysToCompute(String input) {
        if (map.containsKey(input)) return map.get(input);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < input.length(); i++){
            char curChar = input.charAt(i);
            if (curChar == '+' || curChar == '-' || curChar == '*'){
                String leftPart = input.substring(0, i);
                String rightPart = input.substring(i + 1);
                List<Integer> leftResult = diffWaysToCompute(leftPart);
                List<Integer> rightResult = diffWaysToCompute(rightPart);
                for (Integer left : leftResult){
                    for (Integer right : rightResult){
                        int curResult = 0;
                        switch (curChar){
                            case '+':
                                curResult = left + right;
                                break;
                            case '-':
                                curResult = left - right;
                                break;
                            case '*':
                                curResult = left * right;
                                break;
                        }
                        result.add(curResult);
                    }
                }
            }
        }

        if(result.size() == 0){
            result.add(Integer.parseInt(input));
        }

        map.put(input, result);
        return result;
    }
}