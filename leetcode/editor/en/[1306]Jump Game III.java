1306
        Jump Game III
        2022-12-08 17:57:52

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canReach(int[] arr, int start) {
        if (start >= 0 && start < arr.length && arr[start] >= 0) {
            if (arr[start] == 0) {
                return true;
            }
            arr[start] = -arr[start];
            return canReach(arr, start + arr[start]) || canReach(arr, start - arr[start]);
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
