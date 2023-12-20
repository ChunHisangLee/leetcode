2497
        Maximum Star Sum of a Graph
        2022-12-11 00:10:29

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxStarSum(int[] vals, int[][] edges, int k) {
        int n = vals.length;
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            graph[a].add(b);
            graph[b].add(a);
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            List<Integer> curr = graph[i];
            curr.sort((a, b) -> vals[b] - vals[a]);
            int max = vals[i];
            int sum = vals[i];
            for (int j = 0; j < k && j < curr.size(); j++) {
                sum += vals[curr.get(j)];
                max = Math.max(max, sum);
            }
            res = Math.max(res, max);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
