1306
        Jump Game III
        2022-12-08 17:57:52

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    boolean[] isVisited;
    int n;

    public boolean canReach(int[] arr, int start) {
        n = arr.length;
        isVisited = new boolean[n];
        return dfs(arr, start);
    }

    public boolean dfs(int[] arr, int i) {
        if (i < 0 || i >= n || isVisited[i]) {
            return false;
        }
        if (arr[i] == 0) {
            return true;
        }
        isVisited[i] = true;
        return dfs(arr, i + arr[i]) || dfs(arr, i - arr[i]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
DFS:
class Solution {
    boolean[] isVisited;
    int n;

    public boolean canReach(int[] arr, int start) {
        n = arr.length;
        isVisited = new boolean[n];
        return dfs(arr, start);
    }

    public boolean dfs(int[] arr, int i) {
        if (i < 0 || i >= n || isVisited[i]) {
            return false;
        }
        if (arr[i] == 0) {
            return true;
        }
        isVisited[i] = true;
        return dfs(arr, i + arr[i]) || dfs(arr, i - arr[i]);
    }
}


BFS:
class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        boolean[] isVisited = new boolean[n];
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(start);
        while (!dq.isEmpty()) {
            int curr = dq.poll();
            if (curr < 0 || curr >= n || isVisited[curr]) {
                continue;
            }
            if (arr[curr] == 0) {
                return true;
            }
            isVisited[curr] = true;
            dq.add(curr + arr[curr]);
            dq.add(curr - arr[curr]);
        }
        return false;
    }
}
 */