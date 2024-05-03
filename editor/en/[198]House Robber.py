# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]

        prev1 = max(nums[0], nums[1])
        prev2 = nums[0]

        for i in range(2, len(nums)):
            current = max(nums[i] + prev2, prev1)
            prev2 = prev1
            prev1 = current

        return prev1
# leetcode submit region end(Prohibit modification and deletion)
