//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int tribonacci(int n) {
        if (n <= 2) {
            return n == 0 ? 0 : 1;
        }

        int t0 = 0;
        int t1 = 1;
        int t2 = 1;
        int curr = 0;

        for (int i = 3; i <= n; i++) {
            curr = t0 + t1 + t2;
            t0 = t1;
            t1 = t2;
            t2 = curr;
        }

        return curr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
