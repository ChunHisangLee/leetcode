# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def canPlaceFlowers(self, flowerbed: List[int], n: int) -> bool:
        count = 0
        flowerbed = [0] + flowerbed + [0];

        for i in range(1, len(flowerbed) - 1):
            if flowerbed[i - 1] == flowerbed[i] == flowerbed[i + 1] == 0:
                flowerbed[i] = 1
                count += 1

        if count >= n:
            return True
        else:
            return False
# leetcode submit region end(Prohibit modification and deletion)
