# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def countSubarrays(self, nums: List[int], minK: int, maxK: int) -> int:
        count = 0
        last_min = -1
        last_max = -1
        last_invalid = -1

        for i, num in enumerate(nums):
            if num < minK or num > maxK:
                last_min = i
                last_max = i
                last_invalid = i
            if num == minK:
                last_min = i
            if num == maxK:
                last_max = i
            count += min(last_min, last_max) - last_invalid

        return count
# leetcode submit region end(Prohibit modification and deletion)
