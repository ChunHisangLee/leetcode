1136
        Parallel Courses
        2023-02-17 10:46:51

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        int[] inDegree = new int[n + 1];
        for (int[] relation : relations) {
            int prev = relation[0];
            int next = relation[1];
            list.get(prev).add(next);
            inDegree[next]++;
        }
        int count = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i <= n; i++) {
            if (inDegree[i] == 0) {
                dq.add(i);
                count++;
            }
        }
        int res = 0;
        while (!dq.isEmpty()) {
            int size = dq.size();
            res++;
            for (int i = 0; i < size; i++) {
                int index = dq.poll();
                for (int num : list.get(index)) {
                    inDegree[num]--;
                    if (inDegree[num] == 0) {
                        dq.add(num);
                        count++;
                    }
                }
            }
        }
        return n == count - 1 ? res : -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
