1672
Richest Customer Wealth
2022-12-05 18:07:26
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for(int i=0;i<accounts.length;i++){
            int sum=0;
            for(int item:accounts[i]){
                sum+=item;
            }
            if(sum>max)
                max = sum;
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
