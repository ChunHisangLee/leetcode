1295
        Find Numbers with Even Number of Digits
        2023-01-16 01:41:58

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if ((num > 9 && num < 99) || (num > 999 && num < 9999) || num == 100000) {
                count++;
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
