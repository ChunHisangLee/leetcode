# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def countSubarrays(self, nums: List[int], k: int) -> int:
        max_num = max(nums)
        count = 0
        left = 0
        freq = 0

        for right in range(len(nums)):
            if nums[right] == max_num:
                freq += 1

            while freq >= k:
                if nums[left] == max_num:
                    freq -= 1
                left += 1

            count += left

        return count
    # leetcode submit region end(Prohibit modification and deletion)
