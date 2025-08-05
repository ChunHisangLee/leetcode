
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        final int n = fruits.length;
        boolean[] used = new boolean[n];
        int unplaced = 0;

        for (int f : fruits) {
            int pick = -1;
            for (int j = 0; j < n; j++) {
                if (!used[j] && baskets[j] >= f) {
                    pick = j;
                    break;
                }
            }
            if (pick == -1) {
                unplaced++;
            } else {
                used[pick] = true;
            }
        }
        return unplaced;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
