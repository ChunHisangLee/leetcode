# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        isDuplicate = [False] * len(nums)

        for num in nums:
            if isDuplicate[num]:
                return num

            isDuplicate[num] = True

        return -1
# leetcode submit region end(Prohibit modification and deletion)
