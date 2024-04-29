# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def subsequenceSumOr(self, nums: List[int]) -> int:
        result = 0
        prefix_sum = 0

        for num in nums:
            prefix_sum += num
            result |= num
            result |= prefix_sum

        return result
# leetcode submit region end(Prohibit modification and deletion)
