

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  private static final Map<Character, String> DIGIT_TO_LETTERS = new HashMap<>();

  static {
    DIGIT_TO_LETTERS.put('2', "abc");
    DIGIT_TO_LETTERS.put('3', "def");
    DIGIT_TO_LETTERS.put('4', "ghi");
    DIGIT_TO_LETTERS.put('5', "jkl");
    DIGIT_TO_LETTERS.put('6', "mno");
    DIGIT_TO_LETTERS.put('7', "pqrs");
    DIGIT_TO_LETTERS.put('8', "tuv");
    DIGIT_TO_LETTERS.put('9', "wxyz");
  }

  public List<String> letterCombinations(String digits) {
    List<String> result = new ArrayList<>();

    if (digits == null || digits.length() == 0) {
      return result;
    }

    backtrack(digits, 0, new StringBuilder(), result);
    return result;
  }

  private void backtrack(String digits, int index, StringBuilder path, List<String> result) {
    if (index == digits.length()) {
      result.add(path.toString());
      return;
    }

    String letters = DIGIT_TO_LETTERS.get(digits.charAt(index));

    for (char c : letters.toCharArray()) {
      path.append(c);
      backtrack(digits, index + 1, path, result);
      path.deleteCharAt(path.length() - 1);
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
