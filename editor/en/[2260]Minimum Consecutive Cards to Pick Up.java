2260
        Minimum Consecutive Cards to Pick Up
        2022-11-28 13:49:46

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumCardPickup(int[] cards) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < cards.length; i++) {
            int num = cards[i];
            if (map.containsKey(num))
                ans = Math.min(ans, i - map.get(num) + 1);
            map.put(num, i);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
