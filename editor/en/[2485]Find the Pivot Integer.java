
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int pivotInteger(int n) {
        int total = n * (n + 1) / 2;

        for (int i = 1, sum = 0; i <= n; i++) {
            sum += i;

            if (sum * 2 == total + i) {
                return i;
            }
        }

        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
