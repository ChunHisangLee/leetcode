# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findDuplicates(self, nums: List[int]) -> List[int]:
        result = []
        isDupicated = [False] * (len(nums) + 1)

        for num in nums:
            if isDupicated[num]:
                result.append(num)
            else:
                isDupicated[num] = True

        return result

# leetcode submit region end(Prohibit modification and deletion)
