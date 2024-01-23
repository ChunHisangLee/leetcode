//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findErrorNums(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int dup = 0;
        int miss = 0;
        int sum = 0;

        for (int num : nums) {
            if (!set.add(num)) {
                dup = num;
            }

            sum += num;
        }

        miss = (nums.length) * (nums.length + 1) / 2 - sum + dup;
        return new int[]{dup, miss};
    }
}
//leetcode submit region end(Prohibit modification and deletion)
