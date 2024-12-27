
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int result = 0;
        int curr = 0;

        for (int value : values) {
            result = Math.max(result, curr + value);
            curr = Math.max(curr, value) - 1;
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
