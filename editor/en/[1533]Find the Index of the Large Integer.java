1533
        Find the Index of the Large Integer
        2023-01-16 23:22:19
//leetcode submit region begin(Prohibit modification and deletion)

/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 * // Compares the sum of arr[l..r] with the sum of arr[x..y]
 * // return 1 if sum(arr[l..r]) > sum(arr[x..y])
 * // return 0 if sum(arr[l..r]) == sum(arr[x..y])
 * // return -1 if sum(arr[l..r]) < sum(arr[x..y])
 * public int compareSub(int l, int r, int x, int y) {}
 * <p>
 * // Returns the length of the array
 * public int length() {}
 * }
 */

class Solution {
    public int getIndex(ArrayReader reader) {
        int left = 0;
        int right = reader.length() - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            int val = reader.compareSub(left, mid, mid + (right - left) % 2, right);
            if (val == 0) {
                return mid;
            } else if (val < 0) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
