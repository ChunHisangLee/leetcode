// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int numOfSubarrays(int[] arr) {
    int mod = 1_000_000_007;
    int odd = 0;
    int even = 1;
    int curr = 0;
    int result = 0;

    for (int num : arr) {
      curr = (curr + num) % 2;

      if (curr == 0) {
        result = (result + odd) % mod;
        even++;
      } else {
        result = (result + even) % mod;
        odd++;
      }
    }

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
