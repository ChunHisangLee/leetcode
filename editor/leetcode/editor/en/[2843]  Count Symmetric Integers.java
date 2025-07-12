// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int countSymmetricIntegers(int low, int high) {
    int count = 0;

    for (int i = low; i <= high; i++) {
      String numStr = Integer.toString(i);

      if (numStr.length() % 2 != 0) {
        continue;
      }

      int helf = numStr.length() / 2;
      int firstSum = 0;
      int secondSum = 0;

      for (int j = 0; j < helf; j++) {
        firstSum += numStr.charAt(j) - '0';
        secondSum += numStr.charAt(j + helf) - '0';
      }

      if (firstSum == secondSum) {
        count++;
      }
    }

    return count;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
