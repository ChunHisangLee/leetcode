// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
    int n = nums.length;
    boolean[] valid = new boolean[n];

    for (int j = 0; j < n; j++) {
      if (nums[j] == key) {
        int left = Math.max(0, j - k);
        int right = Math.min(n - 1, j + k);

        for (int t = left; t <= right; t++) {
          valid[t] = true;
        }
      }
    }

    List<Integer> ans = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      if (valid[i]) {
        ans.add(i);
      }
    }

    return ans;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
