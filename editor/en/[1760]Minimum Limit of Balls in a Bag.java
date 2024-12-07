
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int maxNum = 0;

        for (int num : nums) {
            if (num > maxNum) {
                maxNum = num;
            }
        }

        int low = 1;
        int high = maxNum;

        while (low < high) {
            int mid = low + (high - low) / 2;
            long operations = 0;

            for (int num : nums) {
                operations += (long)(num - 1) / mid;
                if (operations > maxOperations) {
                    break;
                }
            }

            if (operations <= maxOperations) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
