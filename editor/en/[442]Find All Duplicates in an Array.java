
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        boolean[] isDuplicated = new boolean[nums.length + 1];

        for (int num : nums) {
            if (isDuplicated[num]) {
                result.add(num);
            } else {
                isDuplicated[num] = true;
            }
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
