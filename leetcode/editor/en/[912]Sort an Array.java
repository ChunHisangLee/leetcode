912
        Sort an Array
        2022-12-03 08:02:50

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortArray(int[] nums) {
        int max = arr[0];
        int min = arr[0];
        for (int num : arr) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        int n = max - min;
        int[] nums = new int[n + 1];
        for (int num : arr) {
            nums[num - min]++;
        }
        int index = 0;
        for (int i = 0; i <= n; i++) {
            while (nums[i] > 0) {
                arr[index] = min;
                index++;
                nums[i]--;
            }
            min++;
        }
        return nums;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
