// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int totalFruit(int[] fruits) {
    int n = fruits.length;
    int left = 0;
    int maxCount = 0;
    Map<Integer, Integer> basket = new HashMap<>();

    for (int right = 0; right < n; right++) {
      int currFruit = fruits[right];
      basket.put(currFruit, basket.getOrDefault(currFruit, 0) + 1);

      while (basket.size() > 2) {
        int firstFruit = fruits[left];
        basket.put(firstFruit, basket.get(firstFruit) - 1);

        if (basket.get(firstFruit) == 0) {
          basket.remove(firstFruit);
        }

        left++;
      }

      maxCount = Math.max(maxCount, right - left + 1);
    }

    return maxCount;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
