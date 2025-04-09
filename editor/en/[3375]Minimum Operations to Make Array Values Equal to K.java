// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int minOperations(int[] nums, int k) {
    int N = 101;
    boolean[] hasNum = new boolean[N];
    int count = 0;

    for (int num : nums) {
      hasNum[num] = true;
    }

    for (int i = 0; i < N; i++) {
      if (!hasNum[i]) {
        continue;
      }

      if (i < k) {
        return -1;
      } else if (i > k) {
        count++;
      }
    }

    return count;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
