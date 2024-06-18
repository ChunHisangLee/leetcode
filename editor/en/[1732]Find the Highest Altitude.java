
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestAltitude(int[] gain) {
        int prev = 0;
        int highest = Integer.MIN_VALUE;

        for (int num : gain) {
            highest = Math.max(highest, prev);
            prev += num;
        }

        return highest = Math.max(highest, prev);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
