2300
        Successful Pairs of Spells and Potions
        2022-12-12 00:46:43

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[] potions;

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        this.potions = potions;
        int m = potions.length;
        int n = spells.length;
        int[] arr = new int[n];
        Arrays.sort(potions);
        for (int i = 0; i < n; i++) {
            double target = success / (double) spells[i];
            int index = binarySearch(target);
            arr[i] = m - index;
        }
        return arr;
    }

    private int binarySearch(double target) {
        int left = 0;
        int right = potions.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (potions[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
