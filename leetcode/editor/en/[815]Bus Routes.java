
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        int n = routes.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                if (!map.containsKey(routes[i][j])) {
                    map.put(routes[i][j], new ArrayList<>());
                }
                map.get(routes[i][j]).add(i);
            }
        }
        int count = 0;
        boolean[] isVisited = new boolean[n];
        Deque<Integer> dq = new ArrayDeque<>();
        dq.addAll(map.get(source));
        for (int i = 0; i < map.get(source).size(); i++) {
            isVisited[map.get(source).get(i)] = true;
        }
        while (!dq.isEmpty()) {
            int size = dq.size();
            count++;
            for (int i = 0; i < size; i++) {
                int curr = dq.poll();
                int[] arr = routes[curr];
                for (int j = 0; j < arr.length; j++) {
                    List<Integer> list = map.get(arr[j]);
                    if (arr[j] == target) {
                        return count;
                    }
                    for (int k = 0; k < list.size(); k++) {
                        if (!isVisited[list.get(k)]) {
                            dq.add(list.get(k));
                            isVisited[list.get(k)] = true;
                        }
                    }
                }
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
