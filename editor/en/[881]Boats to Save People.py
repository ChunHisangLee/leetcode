# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def numRescueBoats(self, people: List[int], limit: int) -> int:
        people.sort()
        left, right = 0, len(people) - 1
        result = 0

        while left <= right:
            if people[left] + people[right] <= limit:
                left += 1
            result += 1
            right -= 1

        return result
# leetcode submit region end(Prohibit modification and deletion)
