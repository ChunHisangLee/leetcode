941
        Valid Mountain Array 2023-01-17 23:58:32

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        int index = 0;
        while (index + 1 < n && arr[index] < arr[index + 1]) {
            index++;
        }
        if (index == 0 || index == n - 1) {
            return false;
        }
        while (index + 1 < n && arr[index] > arr[index + 1]) {
            index++;
        }
        return index == n - 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
