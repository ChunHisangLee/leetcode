// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int maxDifference(String s) {
    int[] freq = new int[26];
    int n = s.length();

    for (int i = 0; i < n; i++) {
      char c = s.charAt(i);
      freq[c - 'a']++;
    }

    int maxOdd = Integer.MIN_VALUE;
    int minEven = Integer.MAX_VALUE;

    for (int i = 0; i < 26; i++) {
      int num = freq[i];
      if (num <= 0) {
        continue;
      }
      if (num % 2 != 0 && num > maxOdd) {
        maxOdd = num;
      }
      if (num % 2 == 0 && num < minEven) {
        minEven = num;
      }
    }

    return maxOdd - minEven;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
