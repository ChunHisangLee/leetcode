//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findLatestStep(int[] arr, int m) {
        int res = -1;
        int len = arr.length;
        if (len == m)
            return len;
        int[] nums = new int[len + 2];
        for (int i = 0; i < len; i++) {
            int index = arr[i];
            int leftLen = nums[index - 1];
            int rightLen = nums[index + 1];
            nums[index - leftLen] = nums[index + rightLen] = leftLen + rightLen + 1;
            if (leftLen == m || rightLen == m)
                res = i;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
