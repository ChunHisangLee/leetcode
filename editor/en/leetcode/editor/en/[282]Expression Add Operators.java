
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> results = new ArrayList<>();

        if (num == null || num.length() == 0) {
            return results;
        }

        backtrack(results, "", num, target, 0, 0, 0);
        return results;
    }

    private void backtrack(List<String> results, String path, String num, int target, int pos, long eval, long prev) {
        if (pos == num.length()) {
            if (eval == target) {
                results.add(path);
            }

            return;
        }

        for (int i = pos; i < num.length(); i++) {
            if (i != pos && num.charAt(pos) == '0') {
                break;
            }

            String currStr = num.substring(pos, i + 1);
            long curr = Long.parseLong(currStr);

            if (pos == 0) {
                backtrack(results, path + currStr, num, target, i + 1, curr, curr);
            } else {
                backtrack(results, path + "+" + currStr, num, target, i + 1, eval + curr, curr);
                backtrack(results, path + "-" + currStr, num, target, i + 1, eval - curr, -curr);
                backtrack(results, path + "*" + currStr, num, target, i + 1, eval - prev + prev * curr, prev * curr);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
