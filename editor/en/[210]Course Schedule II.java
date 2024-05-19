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

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int count = 0;
        int[] result = new int[numCourses];

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            result[count] = curr;
            count++;

            for (int num : list.get(curr)) {
                inDegree[num]--;

                if (inDegree[num] == 0) {
                    queue.offer(num);
                }
            }
        }

        if (count == numCourses) {
            return result;
        } else {
            return new int[0];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
