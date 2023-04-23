278
        First Bad Version
        2022-12-29 00:37:10
//leetcode submit region begin(Prohibit modification and deletion)
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        long left = 1;
        long right = n;
        while (left < right) {
            long mid = (left + right) >> 1;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return (int) left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
