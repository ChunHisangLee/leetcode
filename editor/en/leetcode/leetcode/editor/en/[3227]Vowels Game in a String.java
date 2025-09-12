// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public boolean doesAliceWin(String s) {
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      switch (c) {
        case 'a', 'e', 'i', 'o', 'u' -> {
          return true;
        }
      }
    }

    return false;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
