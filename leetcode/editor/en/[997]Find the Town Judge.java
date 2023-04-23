997
        Find the Town Judge
        2023-01-23 20:49:05

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] arrIn = new int[n + 1];
        int[] arrOut = new int[n + 1];
        for (int[] item : trust) {
            arrIn[item[1]]++;
            arrOut[item[0]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (arrIn[i] == n - 1 && arrOut[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
