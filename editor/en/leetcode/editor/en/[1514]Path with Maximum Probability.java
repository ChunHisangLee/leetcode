//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        Map<Integer, List<Pair>> graph = new HashMap<>();

        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double prob = succProb[i];
            graph.get(u).add(new Pair(v, prob));
            graph.get(v).add(new Pair(u, prob));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.prob, a.prob));
        double[] probs = new double[n];
        probs[start_node] = 1.0;
        pq.offer(new Pair(start_node, 1.0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int currNode = curr.node;
            double currProb = curr.prob;

            if (currNode == end_node) {
                return currProb;
            }

            for (Pair neighbor : graph.get(currNode)) {
                int nextNode = neighbor.node;
                double edgeProb = neighbor.prob;
                double newProb = currProb * edgeProb;

                if (newProb > probs[nextNode]) {
                    probs[nextNode] = newProb;
                    pq.offer(new Pair(nextNode, newProb));
                }
            }
        }
        return 0.0;
    }

    private static class Pair {
        int node;
        double prob;

        Pair(int node, double prob) {
            this.node = node;
            this.prob = prob;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
