
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private boolean isBipartite(List<List<Integer>> adjList, int node, int[] colors) {
        for (int neighbor : adjList.get(node)) {
            if (colors[neighbor] == colors[node]) {
                return false;
            }

            if (colors[neighbor] != -1) {
                continue;
            }

            colors[neighbor] = (colors[node] + 1) % 2;

            if (!isBipartite(adjList, neighbor, colors)) {
                return false;
            }
        }
        return true;
    }

    private int getLongestShortestPath(List<List<Integer>> adjList, int srcNode, int n) {
        Queue<Integer> nodesQueue = new LinkedList<>();
        boolean[] visited = new boolean[n];

        nodesQueue.add(srcNode);
        visited[srcNode] = true;
        int distance = 0;

        while (!nodesQueue.isEmpty()) {
            int numOfNodesInLayer = nodesQueue.size();
            for (int i = 0; i < numOfNodesInLayer; i++) {
                int currentNode = nodesQueue.poll();

                for (int neighbor : adjList.get(currentNode)) {
                    if (visited[neighbor]) continue;
                    visited[neighbor] = true;
                    nodesQueue.add(neighbor);
                }
            }
            distance++;
        }
        return distance;
    }

    private int getNumberOfGroupsForComponent(List<List<Integer>> adjList, int node, int[] distances, boolean[] visited) {
        int maxNumberOfGroups = distances[node];
        visited[node] = true;

        for (int neighbor : adjList.get(node)) {
            if (visited[neighbor]) continue;
            maxNumberOfGroups = Math.max(maxNumberOfGroups, getNumberOfGroupsForComponent(adjList, neighbor, distances, visited));
        }
        return maxNumberOfGroups;
    }

    public int magnificentSets(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());

        for (int[] edge : edges) {
            adjList.get(edge[0] - 1).add(edge[1] - 1);
            adjList.get(edge[1] - 1).add(edge[0] - 1);
        }

        int[] colors = new int[n];
        Arrays.fill(colors, -1);

        for (int node = 0; node < n; node++) {
            if (colors[node] != -1) continue;
            colors[node] = 0;
            if (!isBipartite(adjList, node, colors)) return -1;
        }

        int[] distances = new int[n];
        for (int node = 0; node < n; node++) {
            distances[node] = getLongestShortestPath(adjList, node, n);
        }

        int maxNumberOfGroups = 0;
        boolean[] visited = new boolean[n];
        for (int node = 0; node < n; node++) {
            if (visited[node]) continue;
            maxNumberOfGroups += getNumberOfGroupsForComponent(adjList, node, distances, visited);
        }

        return maxNumberOfGroups;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
