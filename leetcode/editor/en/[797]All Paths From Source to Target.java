797
        All Paths From Source to Target
        2022-12-13 17:47:42

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        backtrack(graph, 0, new ArrayList<>());
        return res;
    }

    public void backtrack(int[][] graph, int i, List<Integer> list) {
        list.add(i);
        if (i == graph.length - 1) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int num : graph[i]) {
            backtrack(graph, num, list);
            list.remove(list.size() - 1);
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

    private void backtrack(int[][] graph, int curri, List<List<Integer>> res, List<Integer> path) {
        if (curri == graph.length - 1) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int numi : graph[curri]) {
            path.add(numi);
            backtrack(graph, numi, res, path);
            path.remove(path.size() - 1);
        }
    }
}
 */