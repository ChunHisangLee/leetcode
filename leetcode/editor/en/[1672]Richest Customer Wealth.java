1672
        Richest Customer Wealth
        2022-12-05 18:07:26

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumWealth(int[][] accounts) {
        int max = Integer.MIN_VALUE;
        for (int[] arr : accounts) {
            int sum = 0;
            for (int num : arr) {
                sum += num;
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
