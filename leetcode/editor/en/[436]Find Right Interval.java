
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            map.put(intervals[i][0], i);
        }
        for (int i = 0; i < n; i++) {
            Map.Entry<Integer, Integer> entry = map.ceilingEntry(intervals[i][1]);
            arr[i] = entry == null ? -1 : entry.getValue();
        }
        return arr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
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
 */