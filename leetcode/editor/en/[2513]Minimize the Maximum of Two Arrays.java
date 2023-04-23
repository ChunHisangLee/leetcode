2513
        Minimize the Maximum of Two Arrays
        2022-12-25 02:53:21

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        long left = 1;
        long right = 1_000_000_000;
        long res = right;
        long lcm = ((long) divisor1 * (long) divisor2) / gcd(divisor1, divisor2);

        while (left <= right) {
            long mid = left + (right - left) / 2;
            int x = (int) (mid - mid / divisor1);
            int y = (int) (mid - mid / divisor2);
            int z = (int) (mid - mid / lcm);

            if (x < uniqueCnt1 || y < uniqueCnt2 || z < uniqueCnt1 + uniqueCnt2) {
                left = mid + 1;
            } else {
                res = Math.min(res, mid);
                right = mid - 1;
            }
        }
        return (int) res;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
