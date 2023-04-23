875
        Koko Eating Bananas
        2022-12-12 11:15:02

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int hour = 0;
            for (int pile : piles) {
                hour += (pile + mid - 1) / mid;
                if (hour > h) {
                    break;
                }
            }
            if (hour > h) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
