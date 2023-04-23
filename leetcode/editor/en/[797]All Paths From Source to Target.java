797
        All Paths From Source to Target
        2022-12-13 17:47:42

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(graph, 0, list, new ArrayList<>());
        return list;
    }

    public void backtrack(int[][] graph, int node, List<List<Integer>> list, List<Integer> path) {
        path.add(node);
        if (node == graph.length - 1) {
            list.add(new ArrayList<>(path));
            return;
        }
        for (int nextNode : graph[node]) {
            backtrack(graph, nextNode, list, path);
            path.remove(path.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new LinkedList<>();
        path.add(0);
        backtrack(graph, 0, res, path);
        return res;
    }

    private void backtrack(int[][] graph, int currNode, List<List<Integer>> res, List<Integer> path) {
        if (currNode == graph.length - 1) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int nextNode : graph[currNode]) {
            path.add(nextNode);
            backtrack(graph, nextNode, res, path);
            path.remove(path.size() - 1);
        }
    }
}
 */