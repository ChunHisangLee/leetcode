
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] arr = new int[n];

        for (int[] edge : edges) {
            arr[edge[1]]++;
        }

        int champion = -1;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                if (champion != -1) {
                    return -1;
                }

                champion = i;
            }
        }

        return champion;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
