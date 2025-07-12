// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public boolean isZeroArray(int[] nums, int[][] queries) {
    int n = nums.length;
    int[] diff = new int[n + 1];

    for (int[] query : queries) {
      int left = query[0];
      int right = query[1];
      diff[left]++;
      if (right + 1 < diff.length) {
        diff[right + 1]--;
      }
    }

    int[] cover = new int[n];
    int curr = 0;
    for (int i = 0; i < n; i++) {
      curr += diff[i];
      cover[i] = curr;
    }

    for (int i = 0; i < n; i++) {
      if (cover[i] < nums[i]) {
        return false;
      }
    }

    return true;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
