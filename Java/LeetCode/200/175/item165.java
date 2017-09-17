class Solution {
    public int compareVersion(String version1, String version2) {
        return compareVersion(version1.split("\\."), version2.split("\\."), 0);
    }

    private int compareVersion(String[] version1, String[] version2, int index) {
        if (version1.length <= index && version2.length <= index) return 0;
        int v1 = version1.length <= index ? 0 : Integer.parseInt(version1[index]);
        int v2 = version2.length <= index ? 0 : Integer.parseInt(version2[index]);
        if (v1 > v2) return 1;
        if (v1 < v2) return -1;
        return compareVersion(version1, version2, ++index);
    }
}