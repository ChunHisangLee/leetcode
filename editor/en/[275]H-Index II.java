// 275
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0)
            return 0;
        int len = citations.length;
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (citations[mid] > len - mid)
                right = mid - 1;
            else if (citations[mid] < len - mid)
                left = mid + 1;
            else
                return len - mid;
        }
        return len - left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
