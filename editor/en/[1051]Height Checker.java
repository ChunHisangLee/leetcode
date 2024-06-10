//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int heightChecker(int[] heights) {
        int[] arr = heights.clone();
        int count = 0;
        int n = arr.length;
        Arrays.parallelSort(arr);

        for (int i = 0; i < n; i++) {
            if (arr[i] != heights[i]) {
                count++;
            }
        }

        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
