
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minOperations(List<Integer> nums, int k) {
        Set<Integer> set = new HashSet<>();
        int n = nums.size();
        int count = 0;

        for (int i = n - 1; i >= 0; i--) {
            int num = nums.get(i);
            count++;

            if (num <= k) {
                set.add(num);

                if (set.size() == k) {
                    return count;
                }
            }
        }

        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)