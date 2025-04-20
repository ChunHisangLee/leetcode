// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int subarraySum(int[] nums, int k) {
    int count = 0;
    int currSum = 0;
    Map<Integer, Integer> freqMap = new HashMap<>();
    freqMap.put(0, 1);

    for (int num : nums) {
      currSum += num;
      count += freqMap.getOrDefault(currSum - k, 0);
      int prev = freqMap.getOrDefault(currSum, 0);
      freqMap.put(currSum, prev + 1);
    }

    return count;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
