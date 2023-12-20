2389
        Longest Subsequence With Limited Sum
        2022-12-12 09:57:39

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        int n = queries.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int target = queries[i];
            res[i] = binarySearch(nums, target);
        }
        return res;
    }

    private int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                return mid + 1;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
