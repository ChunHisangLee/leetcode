//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        List<int[]> list = new ArrayList<>();
        int[] curr = intervals[0];
        for (int[] arr : intervals) {
            if (curr[1] < arr[0]) {
                list.add(curr);
                curr = arr;
            } else {
                curr[0] = Math.min(curr[0], arr[0]);
                curr[1] = Math.max(curr[1], arr[1]);
            }
        }
        list.add(curr);
        return list.toArray(new int[list.size()][2]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
