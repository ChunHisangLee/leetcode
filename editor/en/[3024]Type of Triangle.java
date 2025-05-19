// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public String triangleType(int[] nums) {
    Arrays.sort(nums);
    int a = nums[0];
    int b = nums[1];
    int c = nums[2];

    if (a + b <= c) {
      return "none";
    }

    if (a == c) {
      return "equilateral";
    }

    if (a == b || b == c) {
      return "isosceles";
    }

    return "scalene";
  }
}
// leetcode submit region end(Prohibit modification and deletion)
