2187
        Minimum Time to Complete Trips
        2023-03-07 09:46:10

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        int min = Arrays.stream(time).min().getAsInt();
        long left = 1;
        long right = (long) min * totalTrips;
        while (left < right) {
            long mid = left + (right - left) / 2;
            long count = 0;
            for (int num : time) {
                count += mid / num;
                if (count >= totalTrips) {
                    break;
                }
            }
            if (count >= totalTrips) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
