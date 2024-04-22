# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minRemoveToMakeValid(self, s: str) -> str:
        stack = []
        sb = list(s)
        for i in range(len(sb)):
            if sb[i] == '(':
                stack.append(i)
            elif sb[i] == ')':
                if stack:
                    stack.pop()
                else:
                    sb[i] = '*'

        while stack:
            sb[stack.pop()] = '*'

        return ''.join(sb).replace('*', '')

# leetcode submit region end(Prohibit modification and deletion)
