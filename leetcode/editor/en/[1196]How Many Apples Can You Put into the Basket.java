1196
        How Many Apples Can You Put into the Basket
        2022-12-11 01:44:20

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxNumberOfApples(int[] weight) {
        Arrays.sort(weight);
        int basket = 5000;
        int res = 0;
        for (int num : weight) {
            basket -= num;
            if (basket >= 0)
                res++;
            else
                break;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
