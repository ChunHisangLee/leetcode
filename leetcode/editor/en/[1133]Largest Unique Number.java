1133
        Largest Unique Number
        2022-11-27 22:48:59

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestUniqueNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = -1;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) == 1)
                ans = Math.max(ans, key);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
