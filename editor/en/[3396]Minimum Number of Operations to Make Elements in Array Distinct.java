// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int minimumOperations(int[] nums) {
    int n = nums.length;
    int index = n - 1;
    BitSet seen = new BitSet(101);

    while (index >= 0 && !seen.get(nums[index])) {
      seen.set(nums[index]);
      index--;
    }

    return ((index + 1) + 2) / 3;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
