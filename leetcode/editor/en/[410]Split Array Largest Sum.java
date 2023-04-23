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
            int mid = left + (right - left) / 2;
            if (check(mid, nums) <= k) {
                right = mid - 1;
                res = mid;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }

    private int check(int k, int[] nums) {
        int curr = 0;
        int count = 0;
        for (int num : nums) {
            if (curr + num <= k) {
                curr += num;
            } else {
                curr = num;
                count++;
            }
        }
        return count + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
