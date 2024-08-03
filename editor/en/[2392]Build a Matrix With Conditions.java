
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        List<Integer> rowOrder = topologicalSort(k, rowConditions);
        List<Integer> colOrder = topologicalSort(k, colConditions);

        if (rowOrder == null || colOrder == null) {
            return new int[0][0];
        }

        int[][] matrix = new int[k][k];
        int[] rowPosition = new int[k + 1];
        int[] colPosition = new int[k + 1];

        IntStream.range(0, k).forEach(i -> {
            rowPosition[rowOrder.get(i)] = i;
            colPosition[colOrder.get(i)] = i;
        });

        IntStream.rangeClosed(1, k).forEach(i -> {
            matrix[rowPosition[i]][colPosition[i]] = i;
        });

        return matrix;
    }

    private List<Integer> topologicalSort(int k, int[][] conditions) {
        int[] inDegree = new int[k + 1];
        List<List<Integer>> graph = IntStream.rangeClosed(1, k)
                .mapToObj(i -> new ArrayList<Integer>())
                .collect(Collectors.toList());

        Arrays.stream(conditions).forEach(condition -> {
            int u = condition[0];
            int v = condition[1];
            graph.get(u - 1).add(v - 1);
            inDegree[v]++;
        });

        Deque<Integer> queue = IntStream.rangeClosed(1, k)
                .filter(i -> inDegree[i] == 0)
                .boxed()
                .collect(Collectors.toCollection(ArrayDeque::new));

        List<Integer> order = new ArrayList<>();
        while (!queue.isEmpty()) {
            int current = queue.poll();
            order.add(current);
            graph.get(current - 1).forEach(neighbor -> {
                inDegree[neighbor + 1]--;
                if (inDegree[neighbor + 1] == 0) {
                    queue.add(neighbor + 1);
                }
            });
        }

        if (order.size() != k) {
            return null;
        }

        return order;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
