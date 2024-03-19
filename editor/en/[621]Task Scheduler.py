# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        arr = [0] * 26

        for task in tasks:
            arr[ord(task) - ord('A')] += 1;

        maxFreq = max(arr)
        maxCount = arr.count(maxFreq)

        emptySlots = (maxFreq - 1) * (n - maxCount + 1)
        availableTasks = len(tasks) - maxFreq * maxCount
        idleSlots = max(0, emptySlots - availableTasks)
        return len(tasks) + idleSlots

# leetcode submit region end(Prohibit modification and deletion)
