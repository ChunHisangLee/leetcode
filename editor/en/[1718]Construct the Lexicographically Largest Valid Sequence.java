// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  private int[] ans;
  private boolean[] used;
  private int n;

  public int[] constructDistancedSequence(int n) {
    this.n = n;
    int size = 2 * n - 1;
    ans = new int[size];
    used = new boolean[n + 1];
    backtrack(0);
    return ans;
  }

  private boolean backtrack(int index) {
    if (index == ans.length) {
      return true;
    }

    if (ans[index] != 0) {
      return backtrack(index + 1);
    }

    for (int num = n; num >= 1; num--) {
      if (used[num]) {
        continue;
      }

      if (num == 1) {
        ans[index] = 1;
        used[1] = true;

        if (backtrack(index + 1)) {
          return true;
        }

        ans[index] = 0;
        used[1] = false;
      } else {
        int secondIndex = index + num;

        if (secondIndex < ans.length && ans[secondIndex] == 0) {
          ans[index] = num;
          ans[secondIndex] = num;
          used[num] = true;

          if (backtrack(index + 1)) {
            return true;
          }

          ans[index] = 0;
          ans[secondIndex] = 0;
          used[num] = false;
        }
      }
    }

    return false;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
