2246
        Longest Path With Different Adjacent Characters
        2023-01-13 09:33:24

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestPath(int[] parent, String s) {
        int n = parent.length;
        Deque<Integer> dq = new ArrayDeque<>();
        int size[] = new int[n];
        Arrays.fill(size, 1);
        int degree[] = new int[n];
        for (int i = 1; i < n; i++) {
            degree[parent[i]]++;
        }
        for (int i = 1; i < n; i++) {
            if (degree[i] == 0) {
                dq.add(i);
            }
        }
        int res = 1;
        while (!dq.isEmpty()) {
            int curr = dq.poll();
            int par = parent[curr];
            if (--degree[par] == 0 && par != 0) {
                dq.add(par);
            }
            if (s.charAt(curr) != s.charAt(par)) {
                res = Math.max(res, size[curr] + size[par]);
                size[par] = Math.max(size[par], size[curr] + 1);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
