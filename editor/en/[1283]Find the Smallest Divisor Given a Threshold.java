// 1283
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = 0;
        for (int num : nums) {
            high = Math.max(high, num);
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int count = 0;
            boolean notEnough = false;
            for (int num : nums) {
                count += num / mid;
                if (num % mid != 0)
                    count++;
                if (count > threshold) {
                    notEnough = true;
                    break;
                }
            }

            if (count > threshold)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
