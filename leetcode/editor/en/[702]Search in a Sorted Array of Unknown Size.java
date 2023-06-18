702
        Search in a Sorted Array of Unknown Size
        2022-12-29 19:40:18
//leetcode submit region begin(Prohibit modification and deletion)

/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 * public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int left = 0;
        int right = 1;
        while (reader.get(right) < target) {
            left = right;
            right = right * 2;
        }
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (reader.get(mid) == target) {
                return mid;
            } else if (reader.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
