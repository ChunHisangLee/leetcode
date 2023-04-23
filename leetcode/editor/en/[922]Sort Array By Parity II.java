922
        Sort Array By Parity II
        2023-01-18 21:49:18

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int[] arr = new int[nums.length];
        int even = 0;
        int odd = 1;
        for (int num : nums) {
            if (num % 2 == 0) {
                arr[even] = num;
                even += 2;
            } else {
                arr[odd] = num;
                odd += 2;
            }
        }
        return arr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
