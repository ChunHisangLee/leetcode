
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int numSubarrays = n - k + 1;
        int[] results = new int[numSubarrays];

        for (int i = 0; i < numSubarrays; i++) {
            boolean isValid = true;
            int max = nums[i];

            for (int j = i; j < i + k - 1; j++) {
                if (nums[j] >= nums[j + 1]) {
                    isValid = false;
                    break;
                }

                if (nums[j + 1] - nums[j] != 1) {
                    isValid = false;
                    break;
                }

                if (nums[j + 1] > max) {
                    max = nums[j + 1];
                }
            }

            if (isValid) {
                results[i] = max;
            } else {
                results[i] = -1;
            }
        }

        return results;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
