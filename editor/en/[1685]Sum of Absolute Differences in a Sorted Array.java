
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        int leftSum = 0;
        int rightSum = 0;

        for (int num : nums) {
            rightSum += num;
        }

        for (int i = 0; i < n; i++) {
            rightSum -= nums[i];
            arr[i] = (nums[i] * i - leftSum) + (rightSum - nums[i] * (n - i - 1));
            leftSum += nums[i];
        }

        return arr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*

public class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int leftSum = 0, rightSum = 0;

        // Calculate the initial total sum (rightSum)
        for (int num : nums) {
            rightSum += num;
        }

        // Iterate over the array
        for (int i = 0; i < n; i++) {
            // Update the right sum by subtracting the current element
            rightSum -= nums[i];

            // Calculate the sum of absolute differences for nums[i]
            // Left part: nums[i] * i - leftSum
            // Right part: rightSum - nums[i] * (n - i - 1)
            result[i] = nums[i] * i - leftSum + rightSum - nums[i] * (n - i - 1);

            // Update the left sum by adding the current element
            leftSum += nums[i];
        }

        return result;
    }
}

 */
