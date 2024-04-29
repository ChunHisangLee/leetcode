# leetcode submit region begin(Prohibit modification and deletion)
from collections import defaultdict, deque


class Solution:
    def findMinHeightTrees(self, n: int, edges: List[List[int]]) -> List[int]:
        if n == 1:
            return [0]

        graph = defaultdict(list)
        degree = [0] * n

        for u, v in edges:
            graph[u].append(v)
            graph[v].append(u)
            degree[u] += 1
            degree[v] += 1

        leaves = deque(i for i in range(n) if degree[i] == 1)
        remaining_node = n

        while remaining_node > 2:
            size = len(leaves)
            remaining_node -= size

            for _ in range(size):
                leaf = leaves.popleft()

                for neighbor in graph[leaf]:
                    degree[neighbor] -= 1

                    if degree[neighbor] == 1:
                        leaves.append(neighbor)

        return list(leaves)
# leetcode submit region end(Prohibit modification and deletion)
