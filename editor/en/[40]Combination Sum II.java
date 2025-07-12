//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
    List<List<Integer>> result = new ArrayList<>();
    backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

  private void backtrack(
      int[] candidates, int remaining, int start, List<Integer> path, List<List<Integer>> res) {
    if (remaining == 0) {
      res.add(new ArrayList<>(path));
      return;
    }

    for (int i = start; i < candidates.length; i++) {
      if (i > start && candidates[i] == candidates[i - 1]) {
        continue;
      }

      int num = candidates[i];

      if (remaining < num) {
        break;
      }

      path.add(num);
      backtrack(candidates, remaining - num, i, path, res);
      path.remove(path.size() - 1);
    }
  }
}
//leetcode submit region end(Prohibit modification and deletion)
