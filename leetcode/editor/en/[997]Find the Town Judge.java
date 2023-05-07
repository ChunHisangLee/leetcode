997
        Find the Town Judge
        2023-01-23 20:49:05

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] arr = new int[n + 1];
        for (int[] list : trust) {
            arr[list[1]]++;
            arr[list[0]]--;
        }
        for (int i = 1; i <= n; i++) {
            if (arr[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
