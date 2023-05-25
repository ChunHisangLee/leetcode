//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int count = 0;

    public int minReorder(int n, int[][] connections) {
        List<List<int[]>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] edge : connections) {
            list.get(edge[0]).add(new int[]{edge[1], 1});
            list.get(edge[1]).add(new int[]{edge[0], 0});
        }
        boolean[] isVisited = new boolean[n];
        dfs(list, isVisited, 0);
        return count;
    }

    public void dfs(List<List<int[]>> list, boolean[] isVisited, int curr) {
        isVisited[curr] = true;
        for (int[] num : list.get(curr)) {
            if (!isVisited[num[0]]) {
                count += num[1];
                dfs(list, isVisited, num[0]);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
DFS:
class Solution {
    int count = 0;

    public int minReorder(int n, int[][] connections) {
        List<List<int[]>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] edge : connections) {
            list.get(edge[0]).add(new int[]{edge[1], 1});
            list.get(edge[1]).add(new int[]{edge[0], 0});
        }
        boolean[] isVisited = new boolean[n];
        dfs(list, isVisited, 0);
        return count;
    }

    public void dfs(List<List<int[]>> list, boolean[] isVisited, int curr) {
        isVisited[curr] = true;
        for (int[] num : list.get(curr)) {
            if (!isVisited[num[0]]) {
                count += num[1];
                dfs(list, isVisited, num[0]);
            }
        }
    }
}


BFS:
class Solution {
    int count = 0;

    public int minReorder(int n, int[][] connections) {
        List<List<int[]>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] edge : connections) {
            list.get(edge[0]).add(new int[]{edge[1], 1});
            list.get(edge[1]).add(new int[]{edge[0], 0});
        }
        Deque<Integer> dq = new ArrayDeque<>();
        boolean[] isVisited = new boolean[n];
        int res = 0;
        dq.add(0);
        while (!dq.isEmpty()) {
            int curr = dq.poll();
            isVisited[curr] = true;
            for (int[] num : list.get(curr)) {
                if (!isVisited[num[0]]) {
                    res += num[1];
                    dq.add(num[0]);
                }
            }
        }
        return res;
    }
}
 */