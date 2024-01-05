
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> dp = new ArrayList<>();

        for (int num : nums) {
            if (dp.isEmpty() || num > dp.get(dp.size() - 1)) {
                dp.add(num);
            } else {
                int index = Collections.binarySearch(dp, num);

                if (index < 0) {
                    index = -(index + 1);
                }

                dp.set(index, num);
            }
        }

        return dp.size();
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
                }
            }

            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
 */
