# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def __init__(self):
        self.board = None
        self.rows = None
        self.cols = None

    def exist(self, board: List[List[str]], word: str) -> bool:
        self.board = board
        self.rows = len(board)
        self.cols = len(board[0])
        directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]

        for row in range(self.rows):
            for col in range(self.cols):
                if self.backtrack(row, col, word, 0, directions):
                    return True

        return False

    def backtrack(self, row, col, word, index, directions):
        if index == len(word):
            return True

        if row < 0 or row >= self.rows or col < 0 or col >= self.cols \
                or self.board[row][col] != word[index]:
            return False

        self.board[row][col] = '#'
        for rowOffset, colOffset in directions:
            if self.backtrack(row + rowOffset, col + colOffset, word, index + 1, directions):
                return True

        self.board[row][col] = word[index]
        return False

# leetcode submit region end(Prohibit modification and deletion)
