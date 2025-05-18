//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    boolean[] isUsed = new boolean[nums.length];
    backtrack(nums, new ArrayList<>(), isUsed, result);
    return result;
  }

  private void backtrack(
      int[] nums, List<Integer> path, boolean[] isUsed, List<List<Integer>> res) {
    if (path.size() == nums.length) {
      res.add(new ArrayList<>(path));
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      if (isUsed[i]) {
        continue;
      }

      path.add(nums[i]);
      isUsed[i] = true;
      backtrack(nums, path, isUsed, res);
      path.remove(path.size() - 1);
      isUsed[i] = false;
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
