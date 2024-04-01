# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        def knapsack(new_target: int) -> int:
            dp = [0] * (new_target + 1)
            dp[0] = 1
            for num in nums:
                for i in range(new_target, num - 1, -1):
                    dp[i] += dp[i - num]
            return dp[new_target]

        total_sum = sum(nums)

        if abs(target) > total_sum or (total_sum + target) % 2 == 1:
            return 0

        return knapsack((total_sum + target) // 2)

# leetcode submit region end(Prohibit modification and deletion)
