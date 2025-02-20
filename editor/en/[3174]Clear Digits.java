// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public String clearDigits(String s) {
    StringBuilder res = new StringBuilder();

    for(char c : s.toCharArray()) {
      if(Character.isDigit(c)) {
        res.deleteCharAt(res.length()-1);
      }else {
        res.append(c);
      }
    }

    return res.toString();
  }
}
// leetcode submit region end(Prohibit modification and deletion)
