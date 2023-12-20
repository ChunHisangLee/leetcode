2498
        Frog Jump II
        2022-12-11 00:13:50

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxJump(int[] stones) {
        if (stones.length == 2)
            return stones[1];
        int res = Integer.MIN_VALUE;
        for (int i = 2; i < stones.length; i++) {
            res = res > (stones[i] - stones[i - 2]) ? res : (stones[i] - stones[i - 2]);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
