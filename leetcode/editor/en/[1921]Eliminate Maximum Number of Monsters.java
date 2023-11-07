
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = (dist[i] - 1) / speed[i];
        }

        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            if (arr[i] < i) {
                return i;
            }
        }

        return n;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
