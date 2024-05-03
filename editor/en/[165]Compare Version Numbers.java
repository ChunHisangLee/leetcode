
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int length = Math.max(v1.length, v2.length);

        for (int i = 0; i < length; i++) {
            int index1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int index2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;

            if (index1 != index2) {
                return index1 > index2 ? 1 : -1;
            }
        }

        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
