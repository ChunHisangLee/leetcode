// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public long countBadPairs(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    int n = nums.length;
    long count = 0;

    for (int i = 0; i < n; i++) {
      int key = i - nums[i];
      int value = map.getOrDefault(key, 0);
      map.put(key, value + 1);
      count += i - value;
    }

    return count;
  }
}
//leetcode submit region end(Prohibit modification and deletion)
