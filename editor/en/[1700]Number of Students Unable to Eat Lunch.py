# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def countStudents(self, students: List[int], sandwiches: List[int]) -> int:
        count = [students.count(0), students.count(1)]

        for sandwich in sandwiches:
            if count[sandwich] == 0:
                break
            count[sandwich] -= 1

        return sum(count)
# leetcode submit region end(Prohibit modification and deletion)
