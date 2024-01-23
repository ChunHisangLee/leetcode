//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumCost(int[] nums) {
        int[] arr = getSortedArray(nums);
        return nums[0] + arr[0] + arr[1];

    }

    private int[] getSortedArray(int[] num) {
        int n = num.length;
        int[] arr = new int[n - 1];
        System.arraycopy(num, 1, arr, 0, n - 1);
        Arrays.sort(arr);
        return arr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
