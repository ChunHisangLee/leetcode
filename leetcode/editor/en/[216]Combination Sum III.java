216
        Combination Sum III
        2022-12-14 10:42:42

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtreck(k, n, new ArrayList<Integer>(), 1);
        return res;
    }

    private void backtreck(int k, int n, List<Integer> list, int index) {
        if (list.size() == k && n == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i <= 9; i++) {
            list.add(i);
            backtreck(k, n - i, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}

//leetcode submit region end(Prohibit modification and deletion)
