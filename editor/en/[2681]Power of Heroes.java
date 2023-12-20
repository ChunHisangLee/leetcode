
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int sumOfPower(int[] nums) {
        long mod = (long) 1e9 + 7;
        long pre = 0;
        long res = 0;
        Arrays.sort(nums);
        for (long num : nums) {
            res = (res + (num * num % mod) * num % mod + (num * num % mod) * pre % mod) % mod;
            pre = (pre * 2 + num) % mod;
        }
        return (int) res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
