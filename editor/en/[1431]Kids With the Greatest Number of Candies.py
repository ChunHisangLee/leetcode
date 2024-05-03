# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def kidsWithCandies(self, candies: List[int], extraCandies: int) -> List[bool]:
        max_num = max(candies)
        return [candy + extraCandies >= max_num for candy in candies]
# leetcode submit region end(Prohibit modification and deletion)
