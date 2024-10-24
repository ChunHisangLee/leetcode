
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countMaxOrSubsets(int[] nums) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 1);

        for (int num : nums) {
            Map<Integer, Integer> next = new HashMap<>(dp);

            for (Map.Entry<Integer, Integer> entry : dp.entrySet()) {
                int newOr = entry.getKey() | num;
                next.put(newOr, next.getOrDefault(newOr, 0) + entry.getValue());
            }

            dp = next;
        }

        dp.remove(0);
        int maxOr = 0;

        for (int key : dp.keySet()) {
            if (key > maxOr) {
                maxOr = key;
            }
        }

        return dp.getOrDefault(maxOr, 0);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
