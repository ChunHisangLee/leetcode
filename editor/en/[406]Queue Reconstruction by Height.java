

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        List<int[]> list = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        for (int[] person : people) {
            pq.add(person);
        }
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            list.add(curr[1], curr);
        }
        return list.toArray(new int[people.length][2]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
