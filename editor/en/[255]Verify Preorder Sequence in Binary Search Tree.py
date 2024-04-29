# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def verifyPreorder(self, preorder: List[int]) -> bool:
        low = float('-inf')
        i = -1
        for p in preorder:
            if p < low:
                return False
            while i >= 0 and p > preorder[i]:
                low = preorder[i]
                i -= 1
            i += 1
            preorder[i] = p

        return True

# leetcode submit region end(Prohibit modification and deletion)
