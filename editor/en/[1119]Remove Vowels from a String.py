# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def removeVowels(self, s: str) -> str:
        vowels = {'a', 'e', 'i', 'o', 'u'}
        return ''.join(c for c in s if c not in vowels)

# leetcode submit region end(Prohibit modification and deletion)
