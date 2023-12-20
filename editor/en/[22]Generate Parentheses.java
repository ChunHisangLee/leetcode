22
        Generate Parentheses
        2022-12-14 09:40:16

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> list = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrack("", 0, 0, n);
        return list;
    }

    public void backtrack(String str, int left, int right, int n) {
        if (str.length() == 2 * n) {
            list.add(str);
            return;
        }
        if (left < n) {
            backtrack(str + "(", left + 1, right, n);
        }
        if (right < left) {
            backtrack(str + ")", left, right + 1, n);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
