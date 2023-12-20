1462
        Course Schedule IV
        2023-02-15 16:17:27

        https://www.youtube.com/watch?v=mXncR8of7Ns&t=736s

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        Map<Integer, Set<Integer>> map = new HashMap();
        Map<Integer, Set<Integer>> preSet = new HashMap();
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new HashSet<>());
            preSet.put(i, new HashSet<>());
        }
        int[] inDegree = new int[numCourses];
        for (int[] pre : prerequisites) {
            Set<Integer> set = map.get(pre[0]);
            set.add(pre[1]);
            map.put(pre[0], set);
            inDegree[pre[1]]++;
        }

        Deque<Integer> dq = new ArrayDeque();
        for (int i = 0; i < numCourses; i++) {
            Set<Integer> set = preSet.get(i);
            set.add(i);
            preSet.put(i, set);
            if (inDegree[i] == 0) {
                dq.add(i);
            }
        }
        while (!dq.isEmpty()) {
            int curr = dq.poll();
            if (map.containsKey(curr)) {
                for (int course : map.get(curr)) {
                    for (int preCourse : preSet.get(curr)) {
                        Set<Integer> set = preSet.get(course);
                        set.add(preCourse);
                        preSet.put(course, set);
                    }
                    inDegree[course]--;
                    if (inDegree[course] == 0) {
                        dq.add(course);
                    }
                }
            }
        }
        List<Boolean> list = new ArrayList();
        for (int[] query : queries) {
            if (preSet.get(query[1]).contains(query[0])) {
                list.add(true);
            } else {
                list.add(false);
            }
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
