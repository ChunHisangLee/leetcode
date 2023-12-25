
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        Set<Integer> set = new HashSet<>();
        int n = grid.length;
        int[] result = new int[2];
        int sum = (1 + n * n) * (n * n) / 2;

        for (int[] row : grid) {
            for (int num : row) {
                if (!set.add(num)) {
                    result[0] = num;
                }

                sum -= num;
            }
        }

        result[1] = sum + result[0];
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
