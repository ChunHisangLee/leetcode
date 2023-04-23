// 448
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int[] count = new int[nums.length + 1];
        for (int num : nums) {
            count[num] += 1;
        }
        for (int i = 1; i <= nums.length; i++) {
            if (count[i] == 0)
                result.add(i);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
