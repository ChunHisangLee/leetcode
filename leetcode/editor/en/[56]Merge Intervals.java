//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        List<int[]> list = new ArrayList<>();
        int[] arr = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][1] < arr[0]) {
                list.add(intervals[i]);
            } else if (intervals[i][0] > arr[1]) {
                list.add(arr);
                arr = intervals[i];
            } else {
                arr[0] = Math.min(arr[0], intervals[i][0]);
                arr[1] = Math.max(arr[1], intervals[i][1]);
            }
        }
        list.add(arr);
        return list.toArray(new int[list.size()][]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
