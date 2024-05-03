# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findMaxK(self, nums: List[int]) -> int:
        num_set = set(nums)
        max_num = -1

        for num in nums:
            if -num in num_set and num > max_num:
                max_num = num

        return max_num

# leetcode submit region end(Prohibit modification and deletion)
