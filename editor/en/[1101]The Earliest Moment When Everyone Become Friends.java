1101
        The Earliest Moment When Everyone Become Friends
        2023-02-03 12:27:32

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int earliestAcq(int[][] logs, int n) {
        int[] arr = new int[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        for (int[] log : logs) {
            pq.add(log);
        }
        while (!pq.isEmpty()) {
            int[] pair = pq.poll();
            int x = find(arr, pair[1]);
            int y = find(arr, pair[2]);
            if (x != y) {
                arr[x] = y;
                n--;
            }
            if (n == 1) {
                return pair[0];
            }
        }
        return -1;
    }

    private int find(int[] arr, int i) {
        return arr[i] == i ? i : (arr[i] = find(arr, arr[i]));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
