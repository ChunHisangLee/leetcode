
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }

        int n = routes.length;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Set<Integer> busVisited = new HashSet<>();
        Deque<int[]> deque = new ArrayDeque<>();
        boolean[] routeVisited = new boolean[n];

        for (int i = 0; i < n; i++) {
            for (int stop : routes[i]) {
                if (!map.containsKey(stop)) {
                    map.put(stop, new HashSet<>());
                }

                map.get(stop).add(i);
            }
        }

        deque.offer(new int[]{source, 0});
        busVisited.add(source);

        while (!deque.isEmpty()) {
            int[] curr = deque.poll();
            int stop = curr[0];
            int count = curr[1];

            if (stop == target) {
                return count;
            }

            if (!map.containsKey(stop)) {
                continue;
            }

            for (int route : map.get(stop)) {
                if (routeVisited[route]) {
                    continue;
                }

                for (int point : routes[route]) {
                    if (!busVisited.contains(point)) {
                        busVisited.add(point);
                        deque.offer(new int[]{point, count + 1});
                    }
                }

                routeVisited[route] = true;
            }
        }

        return -1;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
/*
To solve this problem in Java, we can use a Breadth-First Search (BFS) approach.
The main idea is to treat each bus as a node in a graph and each bus stop as an edge
connecting the buses. We then perform a BFS from the source bus stop to find the
minimum number of buses required to reach the target bus stop.

The first part loop on routes and record stop to routes mapping in to_route.
The second part is general bfs. Take a stop from queue and find all connected route.
The hashset seen record all visited stops and we won't check a stop for twice.
We can also use a hashset to record all visited routes, or just clear a route after visit.
 */
