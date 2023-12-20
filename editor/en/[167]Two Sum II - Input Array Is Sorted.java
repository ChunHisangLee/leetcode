167
        Two Sum II-Input Array Is Sorted
        2022-12-30 12:06:48

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left <= right) {
            int sum = numbers[left] + numbers[right];
            int mid = (left + right) >> 1;
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                if (numbers[mid] + numbers[right] < target) {
                    left = mid;
                }
                left++;
            } else {
                if (numbers[left] + numbers[mid] > target) {
                    right = mid;
                }
                right--;
            }
        }
        return new int[]{-1, -1};
    }
}
//leetcode submit region end(Prohibit modification and deletion)
