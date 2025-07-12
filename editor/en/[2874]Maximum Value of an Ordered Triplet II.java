
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long maximumTripletValue(int[] nums) {
        long result = 0;
        int maxItem = 0;
        int maxDiff = 0;

        for (int num : nums) {
            result = Math.max(result, (long) maxDiff * num);
            maxItem = Math.max(maxItem, num);
            maxDiff = Math.max(maxDiff, maxItem - num);
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
