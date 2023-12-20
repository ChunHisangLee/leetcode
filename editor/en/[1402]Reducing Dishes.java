

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int res = 0;
        int suf = 0;
        int t = 0;
        for (int i = satisfaction.length - 1; i >= 0; i--) {
            suf += satisfaction[i];
            t += suf;
            res = Math.max(res, t);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
