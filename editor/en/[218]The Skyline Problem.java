218
        The Skyline Problem
        2022-12-26 13:38:58

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> buildings[b][2] - buildings[a][2]);
        List<List<Integer>> list = new ArrayList<>();
        int n = buildings.length;
        Arrays.sort(buildings, (a, b) -> a[0] == b[0] ? b[2] - a[2] : a[0] - b[0]);
        for (int i = 0; i < n; i++) {
            while (!pq.isEmpty() && buildings[pq.peek()][1] < buildings[i][0]) {
                pq.poll();
            }
            if (pq.isEmpty() || buildings[i][2] > buildings[pq.peek()][2]) {
                list.add(Arrays.asList(buildings[i][0], buildings[i][2]));
            }
            pq.add(i);
        }
        pq.clear();
        Arrays.sort(buildings, (a, b) -> a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]);
        for (int i = n - 1; i >= 0; i--) {
            while (!pq.isEmpty() && buildings[pq.peek()][0] > buildings[i][1]) {
                pq.poll();
            }
            if (pq.isEmpty()) {
                list.add(Arrays.asList(buildings[i][1], 0));
            }
            if (!pq.isEmpty() && buildings[i][2] > buildings[pq.peek()][2]) {
                list.add(Arrays.asList(buildings[i][1], buildings[pq.peek()][2]));
            }
            pq.add(i);
        }
        Collections.sort(list, (a, b) -> a.get(0) - b.get(0));
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
