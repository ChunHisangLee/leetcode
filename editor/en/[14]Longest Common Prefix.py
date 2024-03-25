# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        prefix = ""
        for x in zip(*strs):
            if len(set(x)) == 1:
                prefix += x[0]
            else:
                break

        return prefix

# leetcode submit region end(Prohibit modification and deletion)
