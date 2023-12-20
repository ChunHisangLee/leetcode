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
            int mid = (left + right) >>> 1;
            if (isCheck(piles, mid, h)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private boolean isCheck(int[] piles, int mid, int h) {
        int count = 0;
        for (int pile : piles) {
            count += (pile + (mid - 1)) / mid;
            if (count > h) {
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
