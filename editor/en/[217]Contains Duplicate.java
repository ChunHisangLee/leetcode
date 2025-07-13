//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public boolean containsDuplicate(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      if (!set.add(num)) {
        return true;
      }
    }
    return false;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
