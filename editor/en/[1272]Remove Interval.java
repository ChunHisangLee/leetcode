//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> result = new ArrayList<>();
        int removeStart = toBeRemoved[0];
        int removeEnd = toBeRemoved[1];

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            if (end <= removeStart || start >= removeEnd) {
                result.add(List.of(start, end));
            } else {
                if (start < removeStart) {
                    result.add(List.of(start, removeStart));
                }

                if (end > removeEnd) {
                    result.add(List.of(removeEnd, end));
                }
            }
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
