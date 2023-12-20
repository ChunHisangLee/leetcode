class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int left = 0;
        int max = 0;
        int curr = -1;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                if (curr != -1) {
                    max = Math.max(max, right - left);
                    left = curr + 1;
                }

                curr = right;
            }
        }

        return Math.max(max, nums.length - left);
    }
}