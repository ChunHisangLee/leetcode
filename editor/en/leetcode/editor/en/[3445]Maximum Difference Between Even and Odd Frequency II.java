// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int maxDifference(String s, int k) {
    int n = s.length();
    int[] freq = new int[5];
    int ans = Integer.MIN_VALUE;

    for (int i = 0; i < k; i++) {
      freq[s.charAt(i) - '0']++;
    }

    ans = Math.max(ans, calc(freq));

    for (int i = k; i < n; i++) {
      freq[s.charAt(i - k) - '0']--;
      freq[s.charAt(i) - '0']++;
      ans = Math.max(ans, calc(freq));
    }
    return ans;
  }

  private int calc(int[] freq) {
    int max = Integer.MIN_VALUE;
    for (int a = 0; a < 5; a++) {
      if ((freq[a] & 1) == 1) {
        for (int b = 0; b < 5; b++) {
          if (a != b && freq[b] > 0 && (freq[b] & 1) == 0) {
            max = Math.max(max, freq[a] - freq[b]);
          }
        }
      }
    }
    return max;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
