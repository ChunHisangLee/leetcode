338
        Counting Bits
        2023-01-26 01:58:30

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] countBits(int n) {
        int[] arr = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int count = 0;
            int num = i;
            while (num != 0) {
                count++;
                num = num & (num - 1);
            }
            arr[i] = count;
        }
        return arr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
