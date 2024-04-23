# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def gcdOfStrings(self, str1: str, str2: str) -> str:
        gcd_length = self.gcd(len(str1), len(str2))
        candidate = str1[:gcd_length]
        if self.is_divisible(str1, candidate) and self.is_divisible(str2, candidate):
            return candidate
        return ""

    def gcd(self, a, b):
        while b:
            a, b = b, a % b
        return a

    def is_divisible(self, s, t):
        if s == t * (len(s) // len(t)):
            return True
        return False

# leetcode submit region end(Prohibit modification and deletion)
