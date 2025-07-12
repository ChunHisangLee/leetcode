// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int countCompleteSubarrays(int[] nums) {
    Set<Integer> seen = new HashSet<>();

    for (int num : nums) {
      seen.add(num);
    }

    int distinctSize = seen.size();
    int n = nums.length;
    int left = 0;
    int right = 0;
    int answer = 0;
    Map<Integer, Integer> freqMap = new HashMap<>();

    while (right < n) {
      freqMap.merge(nums[right], 1, Integer::sum);

      while (freqMap.size() == distinctSize) {
        answer += (n - right);
        freqMap.put(nums[left], freqMap.get(nums[left]) - 1);

        if (freqMap.get(nums[left]) == 0) {
          freqMap.remove(nums[left]);
        }

        left++;
      }

      right++;
    }

    return answer;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
