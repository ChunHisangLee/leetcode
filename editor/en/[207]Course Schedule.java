//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }

        int[] inDegree = new int[numCourses];

        for (int[] pre : prerequisites) {
            list.get(pre[1]).add(pre[0]);
            inDegree[pre[0]]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int count = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            count++;

            for (int num : list.get(curr)) {
                inDegree[num]--;

                if (inDegree[num] == 0) {
                    queue.offer(num);
                }
            }
        }

        return count == numCourses;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
DFS : - 3ms
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            list.get(pre[1]).add(pre[0]);
        }
        boolean[] isVisited = new boolean[numCourses];
        boolean[] inStack = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (dfs(i, list, isVisited, inStack)) {
                return false;
            }
        }
        return true;
    }

    public boolean dfs(int node, List<List<Integer>> list, boolean[] isVisited, boolean[] inStack) {
        if (inStack[node]) {
            return true;
        }
        if (isVisited[node]) {
            return false;
        }
        isVisited[node] = true;
        inStack[node] = true;
        for (int num : list.get(node)) {
            if (dfs(num, list, isVisited, inStack)) {
                return true;
            }
        }
        inStack[node] = false;
        return false;
    }
}


Topological Sort: - 5ms
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }
        int[] inDegree = new int[numCourses];
        for (int[] pre : prerequisites) {
            list.get(pre[1]).add(pre[0]);
            inDegree[pre[0]]++;
        }
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                dq.add(i);
            }
        }
        int count = 0;
        while (!dq.isEmpty()) {
            int curr = dq.poll();
            count++;
            for (int num : list.get(curr)) {
                inDegree[num]--;
                if (inDegree[num] == 0) {
                    dq.add(num);
                }
            }
        }
        return count == numCourses;
    }
}
 */