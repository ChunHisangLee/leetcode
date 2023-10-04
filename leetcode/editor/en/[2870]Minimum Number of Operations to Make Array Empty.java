
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : map.values()) {
            if (num == 1) {
                return -1;
            }

            if (num % 3 == 0) {
                count += (num / 3);
            } else {
                count += (num / 3 + 1);
            }
        }

        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
