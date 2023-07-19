
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int end = intervals[0][1];
        int count = intervals.length - 1;
        for (int[] arr : intervals) {
            if (arr[0] >= end) {
                end = arr[1];
                count--;
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
