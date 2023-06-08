
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        if (edges.length == 0) {
            return 1;
        }
        char[] c = colors.toCharArray();
        int n = c.length;
        List<List<Integer>> list = new ArrayList<>();
        int[] inDegree = new int[n];
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            list.get(edge[0]).add(edge[1]);
            inDegree[edge[1]]++;
        }
        int[][] count = new int[n][26];
        for (int i = 0; i < n; i++) {
            count[i][c[i] - 'a']++;
        }
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                dq.add(i);
            }
        }
        int max = 1;
        int visited = 0;
        while (!dq.isEmpty()) {
            int curr = dq.poll();
            visited++;
            if (list.get(curr) == null) {
                continue;
            }
            for (int num : list.get(curr)) {
                for (int i = 0; i < 26; i++) {
                    count[num][i] = Math.max(count[num][i], count[curr][i] + (c[num] - 'a' == i ? 1 : 0));
                }
                inDegree[num]--;
                if (inDegree[num] == 0) {
                    dq.add(num);
                }
            }
            for (int num : count[curr]) {
                max = Math.max(max, num);
            }
        }
        return visited == n ? max : -1;
    }
}
//read the official solution
//leetcode submit region end(Prohibit modification and deletion)
