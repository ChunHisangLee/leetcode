# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findMaxLength(self, nums: list[int]) -> int:
        dic = {0: -1}
        maxLen = 0
        sum = 0

        for i, num in enumerate(nums):
            sum += -1 if num == 0 else 1

            if sum in dic:
                maxLen = max(maxLen, (i - dic[sum]))
            else:
                dic[sum] = i

        return maxLen
# leetcode submit region end(Prohibit modification and deletion)
