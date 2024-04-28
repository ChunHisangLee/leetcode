# leetcode submit region begin(Prohibit modification and deletion)
from collections import defaultdict


class Solution:
    def sumOfDistancesInTree(self, n: int, edges: List[List[int]]) -> List[int]:
        graph = defaultdict(list)
        subtree_size = [1] * n
        distance_sum = [0] * n

        for u, v in edges:
            graph[u].append(v)
            graph[v].append(u)

        def dfs(node, parent):
            for child in graph[node]:
                if child != parent:
                    dfs(child, node)
                    subtree_size[node] += subtree_size[child]
                    distance_sum[node] += distance_sum[child] + subtree_size[child]

        def reroot(node, parent):
            for child in graph[node]:
                if child != parent:
                    distance_sum[child] = distance_sum[node] - subtree_size[child] + (n - subtree_size[child])
                    reroot(child, node)

        dfs(0, -1)
        reroot(0, -1)
        return distance_sum
# leetcode submit region end(Prohibit modification and deletion)
