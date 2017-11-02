class Solution {
    public int hIndex(int[] citations) {
        int length = citations.length;
        Arrays.sort(citations);
        int hIndex = 0;
        while (hIndex < length) {
            if (citations[length - 1 - hIndex] > hIndex) hIndex++;
            else break;
        }
        return hIndex;
    }
}