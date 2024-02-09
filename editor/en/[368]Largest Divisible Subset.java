
//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int[] prev = new int[n];
        Arrays.fill(prev, -1);

        int max = 1;
        int index = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }

            if (dp[i] > max) {
                max = dp[i];
                index = i;
            }
        }

        List<Integer> result = new ArrayList<>();

        while (index != -1) {
            result.add(nums[index]);
            index = prev[index];
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
