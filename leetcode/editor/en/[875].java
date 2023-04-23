875
        Koko Eating Bananas
        2023-03-08 11:55:41

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
            if (hour <= h) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
