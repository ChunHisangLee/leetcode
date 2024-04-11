# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def timeRequiredToBuy(self, tickets: List[int], k: int) -> int:
        bench_mark = tickets[k]
        count = 0

        for i in range(len(tickets)):
            if tickets[i] >= bench_mark:
                if i <= k:
                    count += bench_mark
                else:
                    count += bench_mark - 1
            else:
                count += tickets[i]

        return count

    # return sum(min(tickets[i], tickets[k] - (i > k)) for i in range(len(tickets)))
# leetcode submit region end(Prohibit modification and deletion)
