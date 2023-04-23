210
        Course Schedule II
        2023-02-15 16:17:24

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }
        int[] inDegree = new int[numCourses];
        for (int[] pre : prerequisites) {
            int from = pre[1];
            int to = pre[0];
            list.get(from).add(to);
            inDegree[to]++;
        }
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                dq.add(i);
            }
        }
        int[] arr = new int[numCourses];
        int count = 0;
        while (!dq.isEmpty()) {
            int node = dq.poll();
            arr[count] = node;
            count++;
            for (int num : list.get(node)) {
                inDegree[num]--;
                if (inDegree[num] == 0) {
                    dq.add(num);
                }
            }
        }
        return count == numCourses ? arr : new int[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
