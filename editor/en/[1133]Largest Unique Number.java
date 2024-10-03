
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestUniqueNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = -1;
        
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1 && entry.getKey() > result) {
                result = entry.getKey();
            }
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
