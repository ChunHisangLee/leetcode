

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    return kSum(nums, 0, 3, 0);
  }

  private List<List<Integer>> kSum(int[] nums, int target, int k, int start) {
    List<List<Integer>> result = new ArrayList<>();
    int n = nums.length;

    if (k == 2) {
      int left = start;
      int right = n - 1;

      while (left < right) {
        int sum = nums[left] + nums[right];

        if (sum < target) {
          left++;
        } else if (sum > target) {
          right--;
        } else {
          result.add(Arrays.asList(nums[left], nums[right]));
          left++;
          right--;

          while (left < right && nums[left] == nums[left - 1]) {
            left++;
          }

          while (left < right && nums[right] == nums[right + 1]) {
            right--;
          }
        }
      }

      return result;
    }

    for (int i = start; i < n - (k - 1); i++) {
      if (i > start && nums[i] == nums[i - 1]) {
        continue;
      }

      if (nums[i] * k > target) {
        break;
      }

      if (nums[n - 1] * k < target) {
        break;
      }

      List<List<Integer>> subResult = kSum(nums, target - nums[i], k - 1, i + 1);

      for (List<Integer> subset : subResult) {
        List<Integer> tuple = new ArrayList<>();
        tuple.add(nums[i]);
        tuple.addAll(subset);
        result.add(tuple);
      }
    }

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
