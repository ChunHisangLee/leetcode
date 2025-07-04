// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    Arrays.sort(candidates);
    List<List<Integer>> result = new ArrayList<>();
    backtrack(candidates, target, 0, result, new ArrayList<>());
    return result;
  }

  private void backtrack(
      int[] candidates, int target, int start, List<List<Integer>> result, List<Integer> curr) {
    if (target == 0) {
      result.add(new ArrayList<>(curr));
      return;
    }

    for (int i = start; i < candidates.length; i++) {
      int num = candidates[i];

      if (num > target) {
        break;
      }

      curr.add(num);
      backtrack(candidates, target - num, i, result, curr);
      curr.remove(curr.size() - 1);
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
