
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n - k + 1];
        int window = 0;

        for(int i = 0; i < k; i++) {
            window += nums[i];
        }

        sum[0] = window;

        for(int i = 1; i < sum.length; i++) {
            window = window - nums[i - 1] + nums[i + k - 1];
            sum[i] = window;
        }

        int[] left = new int[sum.length];
        int best = 0;

        for(int i = 0; i < sum.length; i++) {
            if(sum[i] > sum[best]) {
                best = i;
            }

            left[i] = best;
        }

        int[] right = new int[sum.length];
        best = sum.length - 1;

        for(int i = sum.length - 1; i >= 0; i--) {
            if(sum[i] >= sum[best]) {
                best = i;
            }

            right[i] = best;
        }

        int max = 0;
        int[] result = new int[3];

        for(int m = k; m < sum.length - k; m++) {
            int l = left[m - k];
            int r = right[m + k];
            int total = sum[l] + sum[m] + sum[r];

            if(total > max) {
                max = total;
                result[0] = l;
                result[1] = m;
                result[2] = r;
            }
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
