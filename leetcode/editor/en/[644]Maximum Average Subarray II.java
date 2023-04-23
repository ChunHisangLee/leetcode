

//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double maxVal = Integer.MIN_VALUE;
        double minVal = Integer.MAX_VALUE;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
            minVal = Math.min(minVal, num);
        }
        double prevMid = maxVal;
        double error = Integer.MAX_VALUE;
        while (error > 0.00001) {
            double mid = (maxVal + minVal) * 0.5;
            if (check(nums, mid, k)) {
                minVal = mid;
            } else {
                maxVal = mid;
            }
            error = Math.abs(prevMid - mid);
            prevMid = mid;
        }
        return minVal;
    }

    public boolean check(int[] nums, double mid, int k) {
        double sum = 0;
        double prev = 0;
        double minSum = 0;
        for (int i = 0; i < k; i++)
            sum += nums[i] - mid;
        if (sum >= 0) {
            return true;
        }
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - mid;
            prev += nums[i - k] - mid;
            minSum = Math.min(prev, minSum);
            if (sum >= minSum) {
                return true;
            }
        }
        return false;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
