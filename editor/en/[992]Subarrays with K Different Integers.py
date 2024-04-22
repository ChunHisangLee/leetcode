# leetcode submit region begin(Prohibit modification and deletion)
from collections import defaultdict


class Solution:
    def subarraysWithKDistinct(self, nums: List[int], k: int) -> int:
        return self.getMost(nums, k) - self.getMost(nums, k - 1)

    def getMost(self, nums: List[int], k: int) -> int:
        count = defaultdict(int)
        left = 0
        result = 0

        for right in range(len(nums)):
            if count[nums[right]] == 0:
                k -= 1
            count[nums[right]] += 1
            while k < 0:
                count[nums[left]] -= 1
                if count[nums[left]] == 0:
                    k += 1
                left += 1
            result += right - left + 1
        return result
# leetcode submit region end(Prohibit modification and deletion)
