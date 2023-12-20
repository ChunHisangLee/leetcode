280
        Wiggle Sort
        2023-02-01 22:41:03

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int index = n - 1;
        for (int i = 1; i < n; i += 2) {
            nums[i] = arr[index];
            index--;
        }
        for (int i = 0; i < n; i += 2) {
            nums[i] = arr[index];
            index--;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
