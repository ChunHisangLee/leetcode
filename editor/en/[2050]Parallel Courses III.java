
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        List<Integer>[] graph = new ArrayList[n];
        int[] inDegree = new int[n];
        Deque<Integer> deque = new ArrayDeque<>();
        int[] maxTime = new int[n];
        int result = 0;

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] arr : relations) {
            int x = arr[0] - 1;
            int y = arr[1] - 1;
            graph[x].add(y);
            inDegree[y]++;
        }

        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                deque.offer(i);
                maxTime[i] = time[i];
            }
        }

        while (!deque.isEmpty()) {
            int curr = deque.poll();

            for (int neighbor : graph[curr]) {
                maxTime[neighbor] = Math.max(maxTime[neighbor], maxTime[curr] + time[neighbor]);
                inDegree[neighbor]--;

                if (inDegree[neighbor] == 0) {
                    deque.offer(neighbor);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            result = Math.max(result, maxTime[i]);
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[n];
        Deque<Integer> deque = new ArrayDeque<>();
        int[] maxTime = new int[n];
        int result = 0;

        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] arr : relations) {
            int x = arr[0] - 1;
            int y = arr[1] - 1;
            graph.get(x).add(y);
            inDegree[y]++;
        }

        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                deque.offer(i);
                maxTime[i] = time[i];
            }
        }

        while (!deque.isEmpty()) {
            int curr = deque.poll();

            for (int neighbor : graph.get(curr)) {
                maxTime[neighbor] = Math.max(maxTime[neighbor], maxTime[curr] + time[neighbor]);
                inDegree[neighbor]--;

                if (inDegree[neighbor] == 0) {
                    deque.offer(neighbor);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            result = Math.max(result, maxTime[i]);
        }

        return result;
    }
}

class Solution {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    Map<Integer, Integer> memo = new HashMap<>();

    public int minimumTime(int n, int[][] relations, int[] time) {
        int result = 0;

        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] arr : relations) {
            int x = arr[0] - 1;
            int y = arr[1] - 1;
            graph.get(x).add(y);
        }

        for (int i = 0; i < n; i++) {
            result = Math.max(result, dfs(i, time));
        }

        return result;
    }

    private int dfs(int i, int[] time) {
        int result = 0;

        if (memo.containsKey(i)) {
            return memo.get(i);
        }

        if (graph.get(i).size() == 0) {
            return time[i];
        }

        for (int neighbor : graph.get(i)) {
            result = Math.max(result, dfs(neighbor, time));
        }

        memo.put(i, time[i] + result);
        return time[i] + result;
    }
}
 */