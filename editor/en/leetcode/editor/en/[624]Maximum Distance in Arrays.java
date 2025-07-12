// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int maxDistance(List<List<Integer>> arrays) {
    int min = arrays.get(0).get(0);
    int max = arrays.get(0).get(arrays.get(0).size() - 1);
    int maxDistance = 0;

    for (int i = 1; i < arrays.size(); i++) {
      List<Integer> list = arrays.get(i);
      int crrMin = list.get(0);
      int currMax = list.get(list.size() - 1);
      maxDistance = Math.max(maxDistance, Math.abs(currMax - min));
      maxDistance = Math.max(maxDistance, Math.abs(crrMin - max));
      min = Math.min(min, crrMin);
      max = Math.max(max, currMax);
    }

    return maxDistance;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
