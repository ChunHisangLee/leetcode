
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minOperations(List<Integer> nums, int k) {
        Set<Integer> set = new HashSet<>();
        int index = nums.size() - 1;
        int count = 0;

        while (set.size() < k) {
            int num = nums.get(index--);
            count++;

            if (num <= k) {
                set.add(num);
            }
        }

        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
