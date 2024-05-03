# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def compareVersion(self, version1: str, version2: str) -> int:
        v1 = list(map(int, version1.split(".")))
        v2 = list(map(int, version2.split(".")))
        length = max(len(v1), len(v2))

        for i in range(length):
            num1 = int(v1[i]) if i < len(v1) else 0
            num2 = int(v2[i]) if i < len(v2) else 0

            if num1 > num2:
                return 1
            elif num1 < num2:
                return -1

        return 0
# leetcode submit region end(Prohibit modification and deletion)
