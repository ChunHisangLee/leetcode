1198
        Find Smallest Common Element in All Rows
        2022-11-28 11:04:16

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int smallestCommonElement(int[][] mat) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = Integer.MAX_VALUE;
        for (int[] nums : mat) {
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) == mat.length)
                ans = Math.min(ans, key);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
