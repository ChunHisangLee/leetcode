
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int gIndex = 0;
        int sIndex = 0;
        int count = 0;
        Arrays.sort(g);
        Arrays.sort(s);

        while (gIndex < g.length && sIndex < s.length) {
            if (g[gIndex] <= s[sIndex]) {
                gIndex++;
                count++;
            }

            sIndex++;
        }

        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
