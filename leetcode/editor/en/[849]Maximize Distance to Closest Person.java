
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxDistToClosest(int[] seats) {
        int left = -1;
        int right = -1;
        int count = 0;
        int max = 0;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 0) {
                count++;
            } else {
                if (left == -1) {
                    max = Math.max(max, count);
                    count = 0;
                    left = i;
                }
                right = i;
                max = Math.max(max, (right - left) / 2);
                left = right;
                count = 0;
            }
        }
        return Math.max(max,count);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
