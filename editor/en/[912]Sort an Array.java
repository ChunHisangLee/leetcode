// 912
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortArray(int[] nums) {
        int temp[] = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, temp);
        return nums;
    }

    public void mergeSort(int[] nums, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(nums, left, mid, temp);
            mergeSort(nums, mid + 1, right, temp);
            merge(nums, left, mid, right, temp);
        }
    }

    public void merge(int[] nums, int left, int mid, int right, int[] temp) {
        int leftIndex = left;
        int rightIndex = mid + 1;
        int tempIndex = 0;
        while (leftIndex <= mid && rightIndex <= right) {
            if (nums[leftIndex] <= nums[rightIndex]) {
                temp[tempIndex] = nums[leftIndex];
                tempIndex++;
                leftIndex++;
            } else {
                temp[tempIndex] = nums[rightIndex];
                tempIndex++;
                rightIndex++;
            }
        }
        while (leftIndex <= mid) {
            temp[tempIndex] = nums[leftIndex];
            tempIndex++;
            leftIndex++;
        }
        while (rightIndex <= right) {
            temp[tempIndex] = nums[rightIndex];
            tempIndex++;
            rightIndex++;
        }
        tempIndex = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            nums[tempLeft] = temp[tempIndex];
            tempLeft++;
            tempIndex++;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
