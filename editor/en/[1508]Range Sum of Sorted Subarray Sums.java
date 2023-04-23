// 1508
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int[] arr = new int[100001];
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = i; j < len; j++) {
                sum += nums[j];
                arr[sum]++;
            }
        }
        int sum = 0;
        int count = 1;
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] >= 1) {
                if (count >= left && count <= right) {
                    sum += i;
                    sum %= 1_000_000_007;
                }
                count++;
                arr[i]--;
            }
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
