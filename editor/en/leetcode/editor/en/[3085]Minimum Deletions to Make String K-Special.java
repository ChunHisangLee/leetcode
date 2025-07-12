// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int minimumDeletions(String word, int k) {
    int[] freq = new int[26];
    for (char c : word.toCharArray()) {
      freq[c - 'a']++;
    }

    List<Integer> frequencies = new ArrayList<>();
    for (int f : freq) {
      if (f > 0) {
        frequencies.add(f);
      }
    }
    Collections.sort(frequencies);

    int minDeletions = Integer.MAX_VALUE;
    int totalChars = word.length();

    for (int i = 0; i < frequencies.size(); i++) {
      int minFreq = frequencies.get(i);
      int currentDeletions = 0;

      for (int j = 0; j < frequencies.size(); j++) {
        int currentFreq = frequencies.get(j);

        if (j < i) {
          currentDeletions += currentFreq;
        } else if (currentFreq > minFreq + k) {
          currentDeletions += currentFreq - (minFreq + k);
        }
      }

      minDeletions = Math.min(minDeletions, currentDeletions);
    }

    return minDeletions;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
