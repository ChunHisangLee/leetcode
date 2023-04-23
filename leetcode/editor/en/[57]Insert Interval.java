57
        Insert Interval
        2022-12-15 16:51:02

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        for (int[] arr : intervals) {
            if (arr[1] < newInterval[0]) {
                list.add(arr);
            } else if (arr[0] > newInterval[1]) {
                list.add(newInterval);
                newInterval = arr;
            } else {
                newInterval[0] = Math.min(newInterval[0], arr[0]);
                newInterval[1] = Math.max(newInterval[1], arr[1]);
            }
        }
        list.add(newInterval);
        return list.toArray(new int[list.size()][]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
