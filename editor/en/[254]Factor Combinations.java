
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(n, 2, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int n, int start, List<Integer> current, List<List<Integer>> res) {
        for (int i = start; i * i <= n; i++) {
            if (n % i == 0) {
                current.add(i);
                current.add(n / i);
                res.add(new ArrayList<>(current));
                current.remove(current.size() - 1);
                backtrack(n / i, i, current, res);
                current.remove(current.size() - 1);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
