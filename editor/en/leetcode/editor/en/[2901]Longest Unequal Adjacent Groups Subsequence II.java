// leetcode submit region begin(Prohibit modification and deletion)
public class Solution {

  public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
    int n = words.length;
    int[] dp = new int[n];
    int[] prev = new int[n];

    for (int j = 0; j < n; j++) {
      dp[j] = 1;
      prev[j] = -1;
    }

    for (int j = 0; j < n; j++) {
      for (int i = 0; i < j; i++) {
        if (groups[i] != groups[j]
            && words[i].length() == words[j].length()
            && hamming(words[i], words[j]) == 1) {
          if (dp[i] + 1 > dp[j]) {
            dp[j] = dp[i] + 1;
            prev[j] = i;
          }
        }
      }
    }

    int maxLen = 0;
    int endIdx = 0;
    for (int j = 0; j < n; j++) {
      if (dp[j] > maxLen) {
        maxLen = dp[j];
        endIdx = j;
      }
    }

    List<String> result = new ArrayList<>();
    for (int cur = endIdx; cur != -1; cur = prev[cur]) {
      result.add(words[cur]);
    }
    Collections.reverse(result);

    return result;
  }

  private int hamming(String a, String b) {
    int diff = 0;
    for (int k = 0; k < a.length(); k++) {
      if (a.charAt(k) != b.charAt(k)) {
        diff++;
      }
    }
    return diff;
  }
}

// leetcode submit region end(Prohibit modification and deletion)
