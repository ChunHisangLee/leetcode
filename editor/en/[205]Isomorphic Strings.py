# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        map1 = {}
        map2 = {}

        for char_s, char_t in zip(s, t):
            if map1.get(char_s, char_t) != char_t or map2.get(char_t, char_s) != char_s:
                return False
            map1[char_s] = char_t
            map2[char_t] = char_s

        return True

# leetcode submit region end(Prohibit modification and deletion)
