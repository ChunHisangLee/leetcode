// 278
//leetcode submit region begin(Prohibit modification and deletion)
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        long left = 1;
        long right = n;
        while (left < right) {
            long mid = (left + right) / 2;
            if (isBadVersion((int) mid))
                right = mid;
            else
                left = mid + 1;
        }
        return (int) left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
