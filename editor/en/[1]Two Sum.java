// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    int n = nums.length;

    for (int i = 0; i < n; i++) {
      int key = target - nums[i];

      if (map.containsKey(key)) {
        return new int[] {map.get(key), i};
      }

      map.put(nums[i], i);
    }

    return new int[] {-1, -1};
  }
}
// leetcode submit region end(Prohibit modification and deletion)
