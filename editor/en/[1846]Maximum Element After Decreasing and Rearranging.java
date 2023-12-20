
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int result = 0;
        Arrays.sort(arr);

        for (int num : arr) {
            result = Math.min(result + 1, num);
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
