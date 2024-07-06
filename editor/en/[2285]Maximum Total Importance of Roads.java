
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long maximumImportance(int n, int[][] roads) {
        long[] degree = new long[n];

        for (int[] road : roads) {
            degree[road[0]]++;
            degree[road[1]]++;
        }

        Arrays.sort(degree);
        long value = 1;
        long result = 0;

        for (long num : degree) {
            result += (value * num);
            value++;
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
