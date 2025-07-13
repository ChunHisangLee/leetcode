// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public boolean canConstruct(String ransomNote, String magazine) {
    int[] freq = new int[26];

    for (char c : magazine.toCharArray()) {
      freq[c - 'a']++;
    }

    for (char c : ransomNote.toCharArray()) {
      int index = c - 'a';
      freq[index]--;

      if (freq[index] < 0) {
        return false;
      }
    }

    return true;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
