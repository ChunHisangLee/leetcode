17
        Letter Combinations of a Phone Number
        2022-12-13 18:24:50

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    final String[] letters = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> list = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return list;
        }
        backtrack(digits, 0, new StringBuilder());
        return list;
    }

    public void backtrack(String digits, int index, StringBuilder sb) {
        if (index == digits.length()) {
            list.add(sb.toString());
            return;
        }
        String letter = letters[digits.charAt(index) - '2'];
        for (char c : letter.toCharArray()) {
            sb.append(c);
            backtrack(digits, index + 1, sb);
            //sb.delete(sb.length() - 1,sb.length());
            //sb.setLength(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
