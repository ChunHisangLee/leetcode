//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> list = new ArrayList<>();
        int left = intervals[0][0];
        int right = intervals[0][1];
        for (int[] arr : intervals) {
            if (right < arr[0]) {
                list.add(new int[]{left, right});
                left = arr[0];
                right = arr[1];
            } else {
                right = Math.max(right, arr[1]);
            }
        }
        list.add(new int[]{left, right});
        return list.toArray(new int[list.size()][]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
