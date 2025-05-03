// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int minDominoRotations(int[] tops, int[] bottoms) {
    int rotations = check(tops[0], tops, bottoms);
    int rotationsForBottom0 = check(bottoms[0], tops, bottoms);
    if (rotationsForBottom0 != -1 && (rotations == -1 || rotationsForBottom0 < rotations)) {
      rotations = rotationsForBottom0;
    }
    return rotations;
  }

  private int check(int x, int[] tops, int[] bottoms) {
    int n = tops.length;
    int rotationsToTop = 0;
    int rotationsToBottom = 0;
    for (int i = 0; i < n; i++) {
      if (tops[i] != x && bottoms[i] != x) {
        return -1;
      }
      if (tops[i] != x) {
        rotationsToTop++;
      }
      if (bottoms[i] != x) {
        rotationsToBottom++;
      }
    }
    return Math.min(rotationsToTop, rotationsToBottom);
  }
}

// leetcode submit region end(Prohibit modification and deletion)
