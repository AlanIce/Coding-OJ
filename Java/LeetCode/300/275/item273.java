class Solution {
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        List<String> result = new ArrayList<>();
        int a = num / 1000000000;
        int b = num % 1000000000 / 1000000;
        int c = num % 1000000 / 1000;
        int d = num % 1000;
        if (a > 0) result.addAll(numberToWords(a, "Billion"));
        if (b > 0) result.addAll(numberToWords(b, "Million"));
        if (c > 0) result.addAll(numberToWords(c, "Thousand"));
        if (d > 0) result.addAll(numberToWords(d, ""));
        return String.join(" ", result);
    }

    public List<String> numberToWords(int num, String suffix) {
        String[] dictOneDight = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
                "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] dictTwoDigth = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        List<String> result = new ArrayList<>();
        if (num / 100 > 0) { result.add(dictOneDight[num / 100]); result.add("Hundred"); }
        if (num % 100 == 0) ;
        else if (num % 100 < 20) result.add(dictOneDight[num % 100]);
        else if (num % 10 == 0) result.add(dictTwoDigth[num % 100 / 10]);
        else { result.add(dictTwoDigth[num % 100 / 10]); result.add(dictOneDight[num % 10]); }
        if (!suffix.equals("")) result.add(suffix);
        return result;
    }
}