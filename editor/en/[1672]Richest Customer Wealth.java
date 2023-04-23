//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int i = 0; i < accounts.length; i++) {
            int sum = 0;
            for (int item : accounts[i]) {
                sum += item;
            }
            if (max < sum)
                max = sum;
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
