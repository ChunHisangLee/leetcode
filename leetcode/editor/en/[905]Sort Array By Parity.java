905
        Sort Array By Parity
        2023-01-18 21:49:17

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        int even = 0;
        int odd = n - 1;
        for (int num : nums) {
            if (num % 2 == 0) {
                arr[even] = num;
                even++;
            } else {
                arr[odd] = num;
                odd--;
            }
        }
        return arr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
