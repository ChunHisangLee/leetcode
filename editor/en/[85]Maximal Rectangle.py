# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maximalRectangle(self, matrix: List[List[str]]) -> int:
        rows = len(matrix)
        cols = len(matrix[0])
        max_area = 0
        height = [0] * cols

        for i in range(rows):
            for j in range(cols):
                if matrix[i][j] == '0':
                    height[j] = 0
                else:
                    height[j] += 1
            max_area = max(max_area, self.largest_rectangle_area(height))

        return max_area

    def largest_rectangle_area(self, heights: List[int]) -> int:
        stack = [-1]
        max_area = 0
        heights.append(0)

        for i in range(len(heights)):
            while stack[-1] != -1 and heights[stack[-1]] > heights[i]:
                h = heights[stack.pop()]
                w = i - stack[-1] - 1
                max_area = max(max_area, h * w)
            stack.append(i)

        heights.pop()
        return max_area

# leetcode submit region end(Prohibit modification and deletion)
