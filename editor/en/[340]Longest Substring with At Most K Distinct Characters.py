# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def lengthOfLongestSubstringKDistinct(self, s: str, k: int) -> int:
        count_count = {}
        left = 0
        result = 0

        for right in range(len(s)):
            char = s[right]
            count_count[char] = count_count.get(char, 0) + 1
            while len(count_count) > k:
                ltft_char = s[left]
                count_count[ltft_char] -= 1
                if count_count[ltft_char] == 0:
                    del count_count[ltft_char]
                left += 1
            result = max(result, right - left + 1)

        return result
# leetcode submit region end(Prohibit modification and deletion)
