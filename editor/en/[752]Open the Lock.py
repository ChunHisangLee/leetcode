# leetcode submit region begin(Prohibit modification and deletion)
from collections import deque


class Solution:
    def openLock(self, deadends: List[str], target: str) -> int:
        dead_set = set(deadends)

        if "0000" in dead_set:
            return -1

        queue = deque(["0000"])
        dead_set.add("0000")
        count = 0

        while queue:
            size = len(queue)

            for _ in range(size):
                curr = queue.popleft()

                if curr == target:
                    return count

                next_states = self.get_next_states(curr)

                for state in next_states:
                    if state not in dead_set:
                        dead_set.add(state)
                        queue.append(state)

            count += 1

        return -1

    def get_next_states(self, curr: str) -> List[str]:
        next_states = []
        chars = list(curr)

        for i in range(4):
            curr_char = chars[i]
            chars[i] = '0' if curr_char == '9' else str(int(curr_char) + 1)
            next_states.append(''.join(chars));
            chars[i] = '9' if curr_char == '0' else str(int(curr_char) - 1)
            next_states.append(''.join(chars));
            chars[i] = curr_char

        return next_states
# leetcode submit region end(Prohibit modification and deletion)
