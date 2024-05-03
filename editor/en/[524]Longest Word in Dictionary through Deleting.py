# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findLongestWord(self, s: str, dictionary: List[str]) -> str:
        dictionary.sort()
        longest_word = ""

        def is_subsequence(w, s):
            w_index = 0
            s_index = 0
            while w_index < len(w) and s_index < len(s):
                if w[w_index] == s[s_index]:
                    w_index += 1
                s_index += 1
            return w_index == len(w)

        for word in dictionary:
            if is_subsequence(word, s):
                if len(word) > len(longest_word):
                    longest_word = word

        return longest_word
# leetcode submit region end(Prohibit modification and deletion)
