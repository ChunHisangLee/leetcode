
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int matrixSum(int[][] nums) {
        int m = nums.length;
        int n = nums[0].length;
        int[] arr = new int[n];
        for (int i = 0; i < m; i++) {
            Arrays.sort(nums[i]);
            for (int j = 0; j < n; j++) {
                if (nums[i][j] > arr[j]) {
                    arr[j] = nums[i][j];
                }
            }
        }
        int res = 0;
        for (int num : arr) {
            res += num;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
