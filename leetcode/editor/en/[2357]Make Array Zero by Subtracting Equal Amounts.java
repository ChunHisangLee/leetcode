
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumOperations(int[] nums) {
        int[] arr = new int[101];
        int count = 0;
        for (int num : nums) {
            if (num > 0 && arr[num] == 0) {
                arr[num]++;
                count++;
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
