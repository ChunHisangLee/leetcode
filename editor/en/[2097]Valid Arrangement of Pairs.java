
//leetcode submit region begin(Prohibit modification and deletion)
import java.util.*;

class Solution {
    public int[][] validArrangement(int[][] pairs) {
        Map<Integer, Deque<Integer>> adj = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, Integer> outDegree = new HashMap<>();

        for (int[] pair : pairs) {
            int start = pair[0];
            int end = pair[1];
            adj.computeIfAbsent(start, k -> new ArrayDeque<>()).add(end);
            outDegree.put(start, outDegree.getOrDefault(start, 0) + 1);
            inDegree.put(end, inDegree.getOrDefault(end, 0) + 1);
        }

        int startNode = pairs[0][0];

        for (int node : outDegree.keySet()) {
            if (outDegree.getOrDefault(node, 0) - inDegree.getOrDefault(node, 0) == 1) {
                startNode = node;
                break;
            }
        }

        List<Integer> path = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(startNode);

        while (!stack.isEmpty()) {
            int current = stack.peek();
            Deque<Integer> neighbors = adj.get(current);

            if (neighbors != null && !neighbors.isEmpty()) {
                int next = neighbors.pollFirst();
                stack.push(next);
            } else {
                path.add(stack.pop());
            }
        }

        Collections.reverse(path);
        int n = path.size();
        int[][] result = new int[n - 1][2];

        for (int i = 0; i < n - 1; i++) {
            result[i][0] = path.get(i);
            result[i][1] = path.get(i + 1);
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
