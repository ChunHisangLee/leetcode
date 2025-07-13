// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int missingNumber(int[] nums) {
    int xorAll = 0;
    int xorNum = 0;
    int n = nums.length;

    for (int i = 0; i < n; i++) {
      xorAll ^= i;
      xorNum ^= nums[i];
    }

    xorAll ^= n;
    return xorAll ^ xorNum;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
