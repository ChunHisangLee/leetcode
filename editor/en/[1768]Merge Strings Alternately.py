# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        result = []
        length1 = len(word1)
        length2 = len(word2)
        min_length = min(length1, length2)

        for i in range(min_length):
            result.append(word1[i])
            result.append(word2[i])

        result.extend(word1[min_length:])
        result.extend(word2[min_length:])
        return ''.join(result)

# leetcode submit region end(Prohibit modification and deletion)
