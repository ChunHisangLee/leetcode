80
        Remove Duplicates from Sorted Array II
        2022-11-29 10:38:47

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int count = 2;
        if (n < 3) {
            return n;
        }
        for (int i = 2; i < n; i++) {
            if (nums[i] != nums[count - 2]) {
                nums[count] = nums[i];
                count++;
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
