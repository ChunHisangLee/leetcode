
//leetcode submit region begin(Prohibit modification and deletion)
import java.util.*;

public class Solution {
    class Edge {
        int to, rev;
        long capacity, cost;
        Edge(int to, int rev, long capacity, long cost) {
            this.to = to;
            this.rev = rev;
            this.capacity = capacity;
            this.cost = cost;
        }
    }

   private void addEdge(List<Edge>[] graph, int from, int to, long capacity, long cost) {
        graph[from].add(new Edge(to, graph[to].size(), capacity, cost));
        graph[to].add(new Edge(from, graph[from].size() -1, 0, -cost));
    }

   private long minCostMaxFlow(List<Edge>[] graph, int N, int source, int sink, long maxFlow) {
        long[] potential = new long[N];
        Arrays.fill(potential, 0);
        long totalCost = 0;
        long flow = 0;

        while (flow < maxFlow) {
            PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
            long[] dist = new long[N];
            Arrays.fill(dist, Long.MAX_VALUE);
            dist[source] = 0;
            pq.offer(new long[]{source, 0});
            int[] prevv = new int[N];
            int[] preve = new int[N];
            Arrays.fill(prevv, -1);
            Arrays.fill(preve, -1);

            while (!pq.isEmpty()) {
                long[] current = pq.poll();
                int u = (int)current[0];
                long d = current[1];

                if (d > dist[u]) {
                    continue;
                }

                for (int i = 0; i < graph[u].size(); i++) {
                    Edge e = graph[u].get(i);

                    if (e.capacity > 0 && dist[e.to] > dist[u] + e.cost + potential[u] - potential[e.to]) {
                        dist[e.to] = dist[u] + e.cost + potential[u] - potential[e.to];
                        prevv[e.to] = u;
                        preve[e.to] = i;
                        pq.offer(new long[]{e.to, dist[e.to]});
                    }
                }
            }

            if (dist[sink] == Long.MAX_VALUE) {
                break;
            }

            for (int v = 0; v < N; v++) {
                potential[v] += dist[v] < Long.MAX_VALUE ? dist[v] : 0;
            }

            long addFlow = maxFlow - flow;
            int v = sink;

            while (v != source) {
                int u = prevv[v];
                Edge e = graph[u].get(preve[v]);
                addFlow = Math.min(addFlow, e.capacity);
                v = u;
            }

            flow += addFlow;
            totalCost += addFlow * potential[sink];
            v = sink;

            while (v != source) {
                int u = prevv[v];
                Edge e = graph[u].get(preve[v]);
                graph[u].set(preve[v], new Edge(e.to, e.rev, e.capacity - addFlow, e.cost));
                Edge rev = graph[v].get(e.rev);
                graph[v].set(e.rev, new Edge(rev.to, rev.rev, rev.capacity + addFlow, rev.cost));
                v = u;
            }
        }

        return totalCost;
    }

    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        int numRobots = robot.size();
        int numFactories = factory.length;
        Collections.sort(robot);
        Arrays.sort(factory, Comparator.comparingInt(a -> a[0]));
        int N = 2 + numRobots + numFactories;
        int source = 0;
        int sink = N -1;

        List<Edge>[] graph = new List[N];

        for(int i=0;i<N;i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0;i<numRobots;i++) {
            addEdge(graph, source, 1 + i, 1, 0);
        }

        for(int i=0;i<numRobots;i++) {
            int robotPos = robot.get(i);
            for(int j=0;j<numFactories;j++) {
                int factoryPos = factory[j][0];
                long distance = Math.abs((long)robotPos - (long)factoryPos);
                addEdge(graph, 1 + i, 1 + numRobots + j, 1, distance);
            }
        }

        for(int j=0;j<numFactories;j++) {
            int limit = factory[j][1];
            addEdge(graph, 1 + numRobots + j, sink, limit, 0);
        }

        long totalCost = minCostMaxFlow(graph, N, source, sink, numRobots);
        return totalCost;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
