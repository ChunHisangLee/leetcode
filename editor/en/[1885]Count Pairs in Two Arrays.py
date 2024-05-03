# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def countPairs(self, nums1: List[int], nums2: List[int]) -> int:
        n = len(nums1)
        nums = [nums1[i] - nums2[i] for i in range(n)]
        nums.sort()
        left, right = 0, n - 1
        result = 0

        while left < right:
            if nums[left] + nums[right] > 0:
                result += right - left
                right -= 1
            else:
                left += 1

        return result
# leetcode submit region end(Prohibit modification and deletion)
