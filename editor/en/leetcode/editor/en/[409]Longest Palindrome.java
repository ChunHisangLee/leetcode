// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int longestPalindrome(String s) {
    int[] freq = new int[128];

    for (char c : s.toCharArray()) {
      freq[c]++;
    }

    int count = 0;
    boolean oddExist = false;

    for (int num : freq) {
      count += (num / 2 * 2);

      if (!oddExist && num % 2 == 1) {
        count++;
        oddExist = true;
      }
    }

    return count;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
