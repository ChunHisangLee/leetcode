
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
        int m = persons.length;
        int n = flowers.length;
        int[] result = new int[m];
        int[] starts = new int[n];
        int[] ends = new int[n];

        for (int i = 0; i < n; i++) {
            starts[i] = flowers[i][0];
            ends[i] = flowers[i][1];
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        for (int i = 0; i < m; i++) {
            int x = binarySearch(starts, persons[i] + 1);
            int y = binarySearch(ends, persons[i]);
            result[i] = x - y;
        }

        return result;
    }

    private int binarySearch(int[] arr, int target) {
        int res = arr.length;
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) >> 1;

            if (arr[mid] >= target) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
