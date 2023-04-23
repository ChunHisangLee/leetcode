
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int n1 = v1.length;
        int n2 = v2.length;
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < Math.max(n1, n2); i++) {
            index1 = i < n1 ? Integer.parseInt(v1[i]) : 0;
            index2 = i < n2 ? Integer.parseInt(v2[i]) : 0;
            if (index1 != index2) {
                return index1 > index2 ? 1 : -1;
            }
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
