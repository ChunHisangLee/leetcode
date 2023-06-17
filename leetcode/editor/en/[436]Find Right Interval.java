
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] arr = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            arr[i] = intervals[i][0];
            map.put(arr[i], i);
        }
        Arrays.sort(arr);
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;
            boolean isFound = false;
            int min = -1;
            int ep = intervals[i][1];
            while (left <= right) {
                int mid = (left + right) >> 1;
                if (arr[mid] >= ep) {
                    min = arr[mid];
                    isFound = true;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            res[i] = isFound ? map.get(min) : -1;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
