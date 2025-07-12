//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;

        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();

            if (map.containsKey(key + 1)) {
                max = Math.max(max, entry.getValue() + map.get(key + 1));
            }
        }

        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
