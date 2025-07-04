// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int maxDistance(String s, int k) {
    int cntN = 0;
    int cntS = 0;
    int cntE = 0;
    int cntW = 0;
    int maxDistance = 0;

    for (int i = 0, len = s.length(); i < len; i++) {
      char c = s.charAt(i);
      switch (c) {
        case 'N':
          cntN++;
          break;
        case 'S':
          cntS++;
          break;
        case 'E':
          cntE++;
          break;
        case 'W':
          cntW++;
          break;
        default:
          break;
      }

      int dx = cntE - cntW;
      int dy = cntN - cntS;

      int base11 = dx + dy;
      int bad11 = cntS + cntW;
      int val11 = base11 + 2 * Math.min(k, bad11);

      int base1m1 = dx - dy;
      int bad1m1 = cntN + cntW;
      int val1m1 = base1m1 + 2 * Math.min(k, bad1m1);

      int basem11 = -dx + dy;
      int badm11 = cntS + cntE;
      int valm11 = basem11 + 2 * Math.min(k, badm11);

      int basemm1 = -dx - dy;
      int badmm1 = cntN + cntE;
      int valmm1 = basemm1 + 2 * Math.min(k, badmm1);

      int curMax = val11;
      if (val1m1 > curMax) {
        curMax = val1m1;
      }
      if (valm11 > curMax) {
        curMax = valm11;
      }
      if (valmm1 > curMax) {
        curMax = valmm1;
      }

      if (curMax > maxDistance) {
        maxDistance = curMax;
      }
    }

    return maxDistance;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
