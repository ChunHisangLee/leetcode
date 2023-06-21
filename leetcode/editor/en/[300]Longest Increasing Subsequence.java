300
        Longest Increasing Subsequence
        2022-12-14 14:51:00

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int count = 0;
        dp[count++] = nums[0];
        for (int i = 1; i < n; i++) {
            if (dp[count - 1] < nums[i]) {
                dp[count++] = nums[i];
            } else {
                int index = binarySearch(dp, 0, count - 1, nums[i]);
                dp[index] = nums[i];
            }
        }
        return count;
    }

    private int binarySearch(int[] dp, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (dp[mid] == target) {
                return mid;
            } else if (dp[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
-- 1ms
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int i = 1, j = 1;
        while (i < nums.length) {
            if (dp[j - 1] < nums[i]) {
                dp[j] = nums[i];
                j++;
            } else {
                int k = 0;
                while (dp[k] < nums[i]) {
                    k++;
                }
                dp[k] = nums[i];
            }
            i++;
        }
        return j;
    }
}

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    res = Math.max(res, dp[i]);
                }
            }
        }
        return res;
    }
}
 */
