# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def wonderfulSubstrings(self, word: str) -> int:
        count = [1] + [0] * 1024
        result = 0
        curr = 0

        for c in word:
            curr ^= 1 << (ord(c) - ord('a'))
            result += count[curr]
            
            for i in range(10):
                result += count[curr ^ (1 << i)]

            count[curr] += 1

        return result
# leetcode submit region end(Prohibit modification and deletion)
