338
        Counting Bits
        2023-01-26 01:58:30

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] countBits(int n) {
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = arr[i & (i - 1)] + 1;
        }
        return arr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
