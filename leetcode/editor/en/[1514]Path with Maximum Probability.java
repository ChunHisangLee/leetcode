1514
        Path with Maximum Probability
        2023-02-14 15:43:20

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        double[] maxProb = new double[n];
        maxProb[start] = 1.0;
        for (int i = 0; i < n; i++) {
            boolean updated = false;
            for (int j = 0; j < edges.length; j++) {
                int x = edges[j][0];
                int y = edges[j][1];
                double pathProb = succProb[j];
                if (maxProb[x] * pathProb > maxProb[y]) {
                    maxProb[y] = maxProb[x] * pathProb;
                    updated = true;
                }
                if (maxProb[y] * pathProb > maxProb[x]) {
                    maxProb[x] = maxProb[y] * pathProb;
                    updated = true;
                }
            }
            if (!updated) {
                break;
            }
        }
        return maxProb[end];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
Dijkstra's Algorithm: -54ms
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, List<Pair<Integer, Double>>> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            double z = succProb[i];
            map.computeIfAbsent(x, k -> new ArrayList<>()).add(new Pair<>(y, z));
            map.computeIfAbsent(y, k -> new ArrayList<>()).add(new Pair<>(x, z));
        }
        double[] maxProb = new double[n];
        maxProb[start] = 1.0;
        PriorityQueue<Pair<Double, Integer>> pq = new PriorityQueue<>((a, b) -> -Double.compare(a.getKey(), b.getKey()));
        pq.add(new Pair<>(1.0, start));
        while (!pq.isEmpty()) {
            Pair<Double, Integer> curr = pq.poll();
            double currProb = curr.getKey();
            int currNode = curr.getValue();
            if (currNode == end) {
                return currProb;
            }
            for (Pair<Integer, Double> next : map.getOrDefault(currNode, new ArrayList<>())) {
                int nextNode = next.getKey();
                double pathProb = next.getValue();
                if (currProb * pathProb > maxProb[nextNode]) {
                    maxProb[nextNode] = currProb * pathProb;
                    pq.add(new Pair<>(maxProb[nextNode], nextNode));
                }
            }
        }
        return 0.0;
    }
}


Bellman-Ford Algorithm: -9ms
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        double[] maxProb = new double[n];
        maxProb[start] = 1.0;
        for (int i = 0; i < n; i++) {
            boolean updated = false;
            for (int j = 0; j < edges.length; j++) {
                int x = edges[j][0];
                int y = edges[j][1];
                double pathProb = succProb[j];
                if (maxProb[x] * pathProb > maxProb[y]) {
                    maxProb[y] = maxProb[x] * pathProb;
                    updated = true;
                }
                if (maxProb[y] * pathProb > maxProb[x]) {
                    maxProb[x] = maxProb[y] * pathProb;
                    updated = true;
                }
            }
            if (!updated) {
                break;
            }
        }
        return maxProb[end];
    }
}
 */
