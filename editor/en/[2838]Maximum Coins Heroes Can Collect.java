
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long[] maximumCoins(int[] heroes, int[] monsters, int[] coins) {
        int m = monsters.length;
        int[][] sortedMonsters = new int[m][2];

        for (int i = 0; i < m; i++) {
            sortedMonsters[i][0] = monsters[i];
            sortedMonsters[i][1] = coins[i];
        }

        Arrays.sort(sortedMonsters, (a, b) -> Integer.compare(a[0], b[0]));
        long[] prefixSum = new long[m];
        prefixSum[0] = sortedMonsters[0][1];

        for (int i = 1; i < m; i++) {
            prefixSum[i] = prefixSum[i - 1] + sortedMonsters[i][1];
        }

        int n = heroes.length;
        long[] result = new long[n];

        for (int i = 0; i < n; i++) {
            int heroPower = heroes[i];
            int index = findLastIndex(sortedMonsters, heroPower);

            if (index != -1) {
                result[i] = prefixSum[index];
            } else {
                result[i] = 0;
            }
        }

        return result;
    }

    private int findLastIndex(int[][] sortedMonsters, int target) {
        int left = 0;
        int right = sortedMonsters.length - 1;
        int index = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (sortedMonsters[mid][0] <= target) {
                index = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return index;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
