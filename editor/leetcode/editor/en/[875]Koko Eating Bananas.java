// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int minEatingSpeed(int[] piles, int h) {
    int left = 1;
    int right = Integer.MIN_VALUE;

    for (int pile : piles) {
      right = Math.max(right, pile);
    }

    while (left < right) {
      int mid = left + (right - left) / 2;

      if (isGreater(piles, mid, h)) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }

    return left;
  }

  private boolean isGreater(int[] piles, int mid, int h) {
    int time = 0;

    for (int pile : piles) {
      time += (pile + (mid - 1)) / mid;

      if (time > h) {
        return true;
      }
    }

    return false;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
