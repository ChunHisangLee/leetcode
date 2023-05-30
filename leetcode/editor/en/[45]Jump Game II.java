45
        Jump Game II
        2022-12-26 09:46:18

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int currFar = 0;
        int currEnd = 0;
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            currFar = Math.max(currFar, i + nums[i]);
            if (currEnd == i) {
                count++;
                currEnd = currFar;
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
DP -Top down -169ms
class Solution {
    int[] dp;
    int n;

    public int jump(int[] nums) {
        n = nums.length;
        dp = new int[n];
        Arrays.fill(dp, -1);
        return dyP(nums, 0);
    }

    public int dyP(int[] nums, int index) {
        if (index == n - 1) {
            return dp[index] = 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        int min = (int) 1e7;
        for (int i = index + 1; (i <= index + nums[index] && i < nums.length); i++) {
            min = Math.min(min, dyP(nums, i) + 1);
        }
        return dp[index] = min;
    }
}


Greedy: 1ms
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int currFar = 0;
        int currEnd = 0;
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            currFar = Math.max(currFar, i + nums[i]);
            if (i == currEnd) {
                count++;
                currEnd = currFar;
            }
        }
        return count;
    }
}
 */