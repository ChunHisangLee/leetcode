
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        int n = routes.length;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Deque<int[]> dq = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        boolean[] routeVisited = new boolean[n];

        for (int i = 0; i < n; i++) {
            for (int key : routes[i]) {
                if (!map.containsKey(key)) {
                    map.put(key, new HashSet<>());
                }
                map.get(key).add(i);
            }
        }

        dq.offer(new int[]{source, 0});
        visited.add(source);

        while (!dq.isEmpty()) {
            int[] curr = dq.poll();
            if (curr[0] == target) {
                return curr[1];
            }

            for (int key : map.get(curr[0])) {
                if (routeVisited[key]) {
                    continue;
                }

                for (int num : routes[key]) {
                    if (!visited.contains(num)) {
                        visited.add(num);
                        dq.offer(new int[]{num, curr[1] + 1});
                    }
                }

                routeVisited[key] = true;
            }
        }

        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
The first part loop on routes and record stop to routes mapping in to_route.
The second part is general bfs. Take a stop from queue and find all connected route.
The hashset seen record all visited stops and we won't check a stop for twice.
We can also use a hashset to record all visited routes, or just clear a route after visit.
 */