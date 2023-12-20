797
        All Paths From Source to Target
        2022-12-13 17:47:42

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    int[][] graph;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        this.graph = graph;
        backtrack(0, graph.length - 1, new ArrayList<>());
        return res;
    }

    public void backtrack(int i, int end, List<Integer> list) {
        list.add(i);
        if (i == end) {
            res.add(new ArrayList<>(list));
        }
        for (int num : graph[i]) {
            backtrack(num, end, list);
            list.remove(list.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
