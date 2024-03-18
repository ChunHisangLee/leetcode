# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findMinArrowShots(self, points: List[List[int]]) -> int:
        points.sort(key=lambda a: a[1])
        result = 1
        reach = points[0][1]

        for point in points:
            if point[0] > reach:
                result += 1
                reach = point[1]

        return result

# leetcode submit region end(Prohibit modification and deletion)
