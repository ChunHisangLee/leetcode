2300
        Successful Pairs of Spells and Potions
        2022-12-12 00:46:43

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] res = new int[spells.length];
        int m = potions.length;
        for (int i = 0; i < spells.length; i++) {
            int j = binarySearch(potions, success / (double) spells[i]);
            res[i] = m - j;
        }
        return res;
    }

    public int binarySearch(int[] arr, double target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= target)
                right = mid-1;
            else
                left = mid + 1;
        }
        return left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
