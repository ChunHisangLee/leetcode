// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
    Map<Integer, Long> freqMap = new HashMap<>();
    freqMap.put(0, 1L);
    long answer = 0;
    int prefixCount = 0;

    for (int num : nums) {
      if (num % modulo == k) {
        prefixCount++;
      }

      int p = prefixCount % modulo;
      int need = (p - k + modulo) % modulo;
      answer += freqMap.getOrDefault(need, 0L);
      freqMap.merge(p, 1L, Long::sum);
    }

    return answer;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
