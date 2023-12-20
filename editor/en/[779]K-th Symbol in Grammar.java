779
        K-th Symbol in Grammar
        2022-12-23 09:54:10

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int kthGrammar(int n, int k) {
        if (n == 1) {
            return 0;
        }

        int parent = kthGrammar(n - 1, (k + 1) / 2);

        if (k % 2 == 0) {
            return parent == 1 ? 0 : 1;
        } else {
            return parent;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
