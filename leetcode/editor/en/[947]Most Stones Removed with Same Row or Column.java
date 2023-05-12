
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[] group;

    public int removeStones(int[][] stones) {
        int n = stones.length;
        group = new int[n];
        for (int i = 0; i < n; i++) {
            group[i] = i;
        }
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    count += union(i, j);
                }
            }
        }
        return count;
    }

    public int find(int x) {
        return group[x] == x ? x : (group[x] = find(group[x]));
    }

    public int union(int i, int j) {
        int x = find(i);
        int y = find(j);
        int res = 0;
        if (x != y) {
            group[x] = y;
            res = 1;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
