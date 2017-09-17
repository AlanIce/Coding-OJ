class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        StringBuilder sb = new StringBuilder();
        if (numerator > 0 ^ denominator > 0) sb.append("-");
        long a = Math.abs((long)numerator);
        long b = Math.abs((long)denominator);
        sb.append(a / b);
        a %= b;
        if (a != 0) sb.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while (a != 0) {
            if (map.containsKey(a)) {
                sb.insert(map.get(a), "(");
                sb.append(")");
                break;
            } else map.put(a, sb.length());
            a *= 10;
            sb.append(a / b);
            a %= b;
        }
        return sb.toString();
    }
}