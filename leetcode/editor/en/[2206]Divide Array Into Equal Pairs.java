2206
        Divide Array Into Equal Pairs
        2023-02-07 15:24:01

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean divideArray(int[] nums) {
        int[] arr = new int[501];
        for (int num : nums) {
            arr[num]++;
        }
        for (int num : arr) {
            if (num % 2 == 1) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
