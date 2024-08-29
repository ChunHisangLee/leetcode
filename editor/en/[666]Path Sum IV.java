//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int pathSum(int[] nums) {
        int[][] pathCounts = new int[5][9];
        int totalSum = 0;

        for (int i = nums.length - 1; i >= 0; i--) {
            int depth = nums[i] / 100;
            int position = (nums[i] / 10) % 10;
            int value = nums[i] % 10;
            pathCounts[depth][position] = Math.max(pathCounts[depth][position], 1);
            totalSum += pathCounts[depth][position] * value;

            if (depth > 1) {
                int parentPosition = (position + 1) / 2;
                pathCounts[depth - 1][parentPosition] += pathCounts[depth][position];
            }
        }

        return totalSum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
