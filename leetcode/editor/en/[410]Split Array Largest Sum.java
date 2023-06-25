410
        Split Array Largest Sum
        2022-12-13 10:07:42

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int splitArray(int[] nums, int k) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }
        int left = max;
        int right = sum;
        int res = 0;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (isCheck(nums, mid, k)) {
                left = mid + 1;
            } else {
                right = mid - 1;
                res = mid;
            }
        }
        return res;
    }

    private boolean isCheck(int[] nums, int mid, int k) {
        int sum = 0;
        int count = 1;
        for (int num : nums) {
            sum += num;
            if (sum > mid) {
                count++;
                sum = num;
            }
        }
        return count > k;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
