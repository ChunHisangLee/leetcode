
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int left = 0;
        int maxSum = 0;
        int windowSum = 0;

        for (int right = 0; right < nums.length; right++) {
            int current = nums[right];
            while (set.contains(current)) {
                int leftVal = nums[left++];
                set.remove(leftVal);
                windowSum -= leftVal;
            }

            set.add(current);
            windowSum += current;
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
