# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        map = {}

        for i, num in enumerate(nums):
            complient = target - num

            if complient in map:
                return [map[complient], i]

            map[num] = i
# leetcode submit region end(Prohibit modification and deletion)
