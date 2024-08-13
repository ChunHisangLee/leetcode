//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, result, target, new ArrayList<>(), 0);
        return result;
    }

    public void backtrack(int[] candidates, List<List<Integer>> result, int target, List<Integer> list, int index) {
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }

            if (candidates[i] > target) {
                break;
            }

            list.add(candidates[i]);
            backtrack(candidates, result, target - candidates[i], list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
