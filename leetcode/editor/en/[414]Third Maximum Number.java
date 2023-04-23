414
        Third Maximum Number
        2023-01-19 18:07:12

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int thirdMax(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return nums[n - 1];
        }
        int count = 1;
        Arrays.sort(nums);
        int res = nums[n - 1];
        for (int i = n - 1; i >= 0; i--) {
            if (res != nums[i]) {
                count++;
                res = nums[i];
                if (count == 3) {
                    return res;
                }
            }
        }
        return nums[n - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
