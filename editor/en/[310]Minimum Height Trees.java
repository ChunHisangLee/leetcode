310
        Minimum Height Trees
        2023-02-16 16:24:12

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n < 2) {
            return List.of(0);
        }
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        int[] inDegree = new int[n];
        for (int[] edge : edges) {
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
            inDegree[edge[0]]++;
            inDegree[edge[1]]++;
        }
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 1) {
                dq.add(i);
            }
        }
        while (n > 2) {
            int size = dq.size();
            n -= size;
            for (int i = 0; i < size; i++) {
                int index = dq.poll();
                for (int num : list.get(index)) {
                    inDegree[num]--;
                    if (inDegree[num] == 1) {
                        dq.add(num);
                    }
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        res.addAll(dq);
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
