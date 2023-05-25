
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dfs(i, manager, informTime));
        }
        return res;
    }

    public int dfs(int curr, int[] manager, int[] informTime) {
        if (manager[curr] != -1) {
            informTime[curr] += dfs(manager[curr], manager, informTime);
            manager[curr] = -1;
        }
        return informTime[curr];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dfs(i, manager, informTime));
        }
        return res;
    }

    public int dfs(int i, int[] manager, int[] informTime) {
        if (manager[i] != -1) {
            informTime[i] += dfs(manager[i], manager, informTime);
            manager[i] = -1;
        }
        return informTime[i];
    }
}


DFS:
class Solution {
    int res = 0;

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            if (manager[i] != -1) {
                list.get(manager[i]).add(i);
            }
        }
        dfs(list, informTime, headID, 0);
        return res;
    }

    public void dfs(List<List<Integer>> list, int[] informTime, int curr, int time) {
        res = Math.max(res, time);
        for (int num : list.get(curr)) {
            dfs(list, informTime, num, time + informTime[curr]);
        }
    }
}


BFS:
class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int[] arr = new int[n];
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            if (manager[i] != -1) {
                list.get(manager[i]).add(i);
            }
        }
        int res = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(headID);
        while (!dq.isEmpty()) {
            int curr = dq.poll();
            for (int num : list.get(curr)) {
                arr[num] = arr[curr] + informTime[curr];
                res = Math.max(res, arr[num]);
                dq.add(num);
            }
        }
        return res;
    }
}
 */