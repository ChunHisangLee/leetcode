//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int countOnes = 0;

        for (int num : nums) {
            countOnes += num;
        }

        if (countOnes == 0 || countOnes == n) {
            return 0;
        }

        int currOnes = 0;

        for (int i = 0; i < countOnes; i++) {
            currOnes += nums[i];
        }

        int maxOnes = currOnes;

        for (int i = countOnes; i < n + countOnes; i++) {
            currOnes += nums[i % n] - nums[(i - countOnes) % n];
            maxOnes = Math.max(maxOnes, currOnes);
        }

        return countOnes - maxOnes;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int countOnes = Arrays.stream(nums).sum();

        if (countOnes == 0 || countOnes == n) {
            return 0;
        }

        int currOnes = Arrays.stream(nums, 0, countOnes).sum();
        int maxOnes = currOnes;

        for (int i = countOnes; i < n + countOnes; i++) {
            currOnes += nums[i % n] - nums[(i - countOnes) % n];
            maxOnes = Math.max(maxOnes, currOnes);
        }

        return countOnes - maxOnes;
    }
}
 */
