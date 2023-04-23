779
        K-th Symbol in Grammar
        2022-12-23 09:54:10

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int kthGrammar(int n, int k) {
        if (n == 1) {
            return 0;
        }
        int parent = kthGrammar(n - 1, k / 2 + k % 2);
        boolean isOdd = k % 2 == 1;
        if (parent == 1) {
            return isOdd ? 1 : 0;
        } else {
            return isOdd ? 0 : 1;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
