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
        int[] arr = new int[numCourses];
        while (!dq.isEmpty()) {
            int curr = dq.poll();
            arr[count] = curr;
            count++;
            for (int num : list.get(curr)) {
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
