// 1539
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthPositive(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] - i > k)
                return i + k;
        }
        return arr.length + k;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
