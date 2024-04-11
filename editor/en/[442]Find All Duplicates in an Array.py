# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findDuplicates(self, nums: List[int]) -> List[int]:
        result = []
        my_set = set()

        for num in nums:
            if num in my_set:
                result.append(num)
            else:
                my_set.add(num)

        return result

# leetcode submit region end(Prohibit modification and deletion)
