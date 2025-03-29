
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int len = arr.length;
        int left = 0;
        int right = len - 1;

        while (left + 1 < len && arr[left] <= arr[left + 1]) {
            left++;
        }

        while (right - 1 >= left && arr[right] >= arr[right - 1]) {
            right--;
        }

        if (left == right) {
            return 0;
        }

        int ans = Math.min(len - left - 1, right);
        int i = 0;
        int j = right;

        while (i <= left && j < len) {
            if (arr[i] <= arr[j]) {
                ans = Math.min(ans, j - i - 1);
                i++;
            } else {
                j++;
            }
        }

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
