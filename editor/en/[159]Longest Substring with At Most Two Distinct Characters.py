# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def lengthOfLongestSubstringTwoDistinct(self, s: str) -> int:
        char_map = {}
        left = 0
        max_length = 0

        for right, char in enumerate(s):
            if char in char_map:
                char_map[char] += 1
            else:
                char_map[char] = 1

            while len(char_map) > 2:
                left_char = s[left]
                char_map[left_char] -= 1
                if char_map[left_char] == 0:
                    del char_map[left_char]
                left += 1
            max_length = max(max_length, right - left + 1)

        return max_length
# leetcode submit region end(Prohibit modification and deletion)
